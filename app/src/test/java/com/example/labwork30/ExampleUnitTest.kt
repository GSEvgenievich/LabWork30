package com.example.labwork30

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun divide_positiveNumbers_returnCorrectResult() {
        val logger = mock<Logger>()
        val result = Divide(10.0, 2.0, logger)
        verify(logger).v("LabWork30", "Вызов divide с аргументами a=10.0, b=2.0")
        verify(logger).i("LabWork30", "Результат деления: 5.0")
    }

    @Test
    fun divide_positiveNumbers_returnUncorrectResult() {
        val logger = mock<Logger>()
        val result = Divide(2.0, 2.0, logger)
        verify(logger).i("LabWork30", "Результат деления: 0.0")
    }

    @Test
    fun divide_divisionByZero_throwException() {
        val logger = mock<Logger>()
        assertThrows(IllegalArgumentException::class.java){
            Divide(10.0, 0.0, logger)
        }
        verify(logger).e("LabWork30", "Ошибка: деление на ноль")
    }
}