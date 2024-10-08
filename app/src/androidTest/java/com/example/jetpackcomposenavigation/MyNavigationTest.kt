package com.example.jetpackcomposenavigation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MyNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testNavigationWithMessagePassing() {
        // 測試導航從HomeScreen到DetailScreen
        composeTestRule.onNodeWithText("Go to Detail Screen").performClick()
        composeTestRule.onNodeWithText("Message from HomeScreen: Hello from HomeScreen").assertExists()
    }
}
