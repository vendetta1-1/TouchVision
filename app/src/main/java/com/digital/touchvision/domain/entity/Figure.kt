package com.digital.touchvision.domain.entity

sealed interface Figure {

    data object Circle : Figure

    data object Unknown : Figure

    //нужно придумать еще фигуры на которые будем реагировать
}