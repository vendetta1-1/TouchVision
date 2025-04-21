package com.digital.touchvision.data.recognition

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ColorSpace
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import com.digital.touchvision.TouchVisionApp
import com.digital.touchvision.domain.usecase.RecognizeFigureInkUseCase
import com.digital.touchvision.domain.usecase.RecognizeTextOnScreenUseCase
import java.util.Locale

class VisionService : AccessibilityService() {

    private val component by lazy {
        (application as TouchVisionApp).component
    }

    private val textToSpeech by lazy {
        TextToSpeech(
            this,
            object : TextToSpeech.OnInitListener {
                override fun onInit(status: Int) {
                    if (status == TextToSpeech.SUCCESS) {
                        setLanguage()
                    }
                }
            },
            TextToSpeech.Engine.ACTION_GET_SAMPLE_TEXT
        )
    }

    private fun setLanguage() {
        textToSpeech.language = Locale.getDefault()
    }

    private lateinit var inkRecognizeFigureInkUseCase: RecognizeFigureInkUseCase
    private lateinit var textRecognizeTextOnScreenUseCase: RecognizeTextOnScreenUseCase

    override fun onCreate() {
        super.onCreate()
        setLanguage()
        inkRecognizeFigureInkUseCase = component.getRecognizeFigureInkUseCase()
        textRecognizeTextOnScreenUseCase = component.getRecognizeTextOnScreenUseCase()
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
                        val text = textRecognizeTextOnScreenUseCase(it)
                        textToSpeech.speak(
                            text,
                            TextToSpeech.QUEUE_FLUSH,
                            Bundle.EMPTY,
                            "text_on_screen"
                        )
                    }
                }

                override fun onFailure(errorCode: Int) {
                    Log.e("Accessibility", "Screenshot failed: $errorCode")
                }
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }

    override fun onInterrupt() {}

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, VisionService::class.java)
    }
}