package com.volie.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.volie.todocompose.ui.theme.HighPriorityColor
import com.volie.todocompose.ui.theme.LowPriorityColor
import com.volie.todocompose.ui.theme.MediumPriorityColor
import com.volie.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}