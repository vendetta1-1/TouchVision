package com.digital.touchvision.data.recognition

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.graphics.Bitmap
import android.graphics.ColorSpace
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.digital.touchvision.TouchVisionApp
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class VisionService : AccessibilityService() {

    private val component by lazy {
        (application as TouchVisionApp).component
    }

    //вместо recognizer нужно инжектить usecase'ы
    private lateinit var textRecognizer: TextRecognizer

    override fun onCreate() {
        super.onCreate()
        textRecognizer = component.getTextRecognizer()
    }

    override fun onServiceConnected() {
        val config = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags = AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
        }
        serviceInfo = config
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                analyzeScreenContent()
            }
        }
    }

    private fun analyzeScreenContent() {
        takeScreenshot(
            GLOBAL_ACTION_TAKE_SCREENSHOT,
            mainExecutor,
            object : TakeScreenshotCallback {
                override fun onSuccess(screenshot: ScreenshotResult) {
                    Bitmap.wrapHardwareBuffer(
                        screenshot.hardwareBuffer,
                        ColorSpace.get(ColorSpace.Named.SRGB)
                    )?.let {
                        processImageWithMLKit(
                            it
                        )

                    }
                }

                override fun onFailure(errorCode: Int) {
                    Log.e("Accessibility", "Screenshot failed: $errorCode")
                }
            }
        )
    }

    private fun processImageWithMLKit(bitmap: Bitmap) {
        val image = InputImage.fromBitmap(bitmap, 0)
        textRecognizer.process(image)
            .addOnSuccessListener { visionText ->

            }
            .addOnFailureListener { e ->
                Log.e("MLKit", "Text recognition error", e)
            }
    }

    override fun onInterrupt() {}
}