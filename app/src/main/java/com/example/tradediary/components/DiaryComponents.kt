package com.example.tradediary.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


@Composable
fun DiaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
){
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier,
    ) {
        Text(text)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DiaryInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 2,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit
) {
    val keyBoardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent),
        maxLines = maxLine,
        label = {Text(label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Default),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyBoardController?.hide() }),
        modifier = modifier
        ) }