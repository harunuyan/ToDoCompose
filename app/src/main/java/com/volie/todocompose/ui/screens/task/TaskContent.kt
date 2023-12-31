package com.volie.todocompose.ui.screens.task

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.volie.todocompose.R
import com.volie.todocompose.components.PriorityDropDown
import com.volie.todocompose.data.models.Priority
import com.volie.todocompose.ui.theme.LARGE_PADDING
import com.volie.todocompose.ui.theme.MEDIUM_PADDING
import com.volie.todocompose.ui.theme.taskItemTextColor

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = {
                Text(
                    text = stringResource(id = R.string.title),
                    color = MaterialTheme.colorScheme.taskItemTextColor
                )
            },
            textStyle = androidx.compose.material.MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colorScheme.taskItemTextColor
            ),
            singleLine = true,
        )

        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colorScheme.background
        )

        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = {
                Text(
                    text = stringResource(id = R.string.description),
                    color = MaterialTheme.colorScheme.taskItemTextColor
                )
            },
            textStyle = androidx.compose.material.MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colorScheme.taskItemTextColor
            )
        )
    }
}

@Composable
@Preview(showSystemUi = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
private fun TaskContentPreview() {
    TaskContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}