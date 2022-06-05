package br.ufrpe.ip2.va3.questao3.view.HelperViews;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    private boolean validate(String text) {
        boolean alreadyContainsDot = this.getText().contains(".") && text.endsWith(".");
        return text.matches("^\\d*\\.?\\d*$") && !alreadyContainsDot;
    }
    @Override
    public void replaceText(int start, int end, String text) {
        if(this.validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (this.validate(text)) {
            super.replaceSelection(text);
        }
    }
}
