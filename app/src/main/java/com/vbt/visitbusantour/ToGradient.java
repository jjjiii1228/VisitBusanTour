package com.vbt.visitbusantour;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class ToGradient extends CharacterStyle implements UpdateAppearance {
    private String containingText;
    private String textToStyle;
    private int startColor;
    private int endColor;

    public ToGradient(String containingText, String textToStyle, int startColor, int endColor) {
        this.containingText = containingText;
        this.textToStyle = textToStyle;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void updateDrawState(TextPaint tp) {
        if (tp == null) {
            return;
        }

        float leadingWidth = 0f;
        int indexOfTextToStyle = containingText.indexOf(textToStyle);
        if (!containingText.startsWith(textToStyle) && !containingText.equals(textToStyle)) {
            leadingWidth = tp.measureText(containingText, 0, indexOfTextToStyle);
        }
        float gradientWidth = tp.measureText(containingText, indexOfTextToStyle, indexOfTextToStyle + textToStyle.length());

        tp.setShader(new LinearGradient(
                leadingWidth,
                0f,
                leadingWidth + gradientWidth,
                0f,
                startColor,
                endColor,
                Shader.TileMode.REPEAT
        ));
    }

}
