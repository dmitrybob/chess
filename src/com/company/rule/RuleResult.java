package com.company.rule;

public class RuleResult {
    public boolean isSucces;
    public String errorMsg;

    public RuleResult() {
        isSucces = true;
    }

    public RuleResult(String errorMsg) {
        isSucces = false;
        this.errorMsg = errorMsg;
    }
}
