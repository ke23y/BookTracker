package com.example.etta.booktracker.dialogues;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/example/etta/booktracker/dialogues/DialogueFinished;", "Landroid/support/v4/app/DialogFragment;", "()V", "etAuthor", "Landroid/widget/EditText;", "etEndDate", "etISBN", "etLanguage", "etName", "etStartDate", "etSubject", "finishedHandler", "Lcom/example/etta/booktracker/dialogues/DialogueFinished$FinishedHandler;", "spinner", "Landroid/widget/Spinner;", "spinnerCategory", "", "", "getSpinnerCategory", "()[Ljava/lang/String;", "setSpinnerCategory", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "handleItemCreate", "", "handleItemEdit", "onAttach", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "FinishedHandler", "app_debug"})
public final class DialogueFinished extends android.support.v4.app.DialogFragment {
    private com.example.etta.booktracker.dialogues.DialogueFinished.FinishedHandler finishedHandler;
    private android.widget.EditText etName;
    private android.widget.EditText etAuthor;
    private android.widget.EditText etISBN;
    private android.widget.EditText etLanguage;
    private android.widget.EditText etSubject;
    private android.widget.EditText etStartDate;
    private android.widget.EditText etEndDate;
    private android.widget.Spinner spinner;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] spinnerCategory;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getSpinnerCategory() {
        return null;
    }
    
    public final void setSpinnerCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    /**
     * * Create a new
     */
    private final void handleItemCreate() {
    }
    
    private final void handleItemEdit() {
    }
    
    public DialogueFinished() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/etta/booktracker/dialogues/DialogueFinished$FinishedHandler;", "", "finishedCreated", "", "item", "Lcom/example/etta/booktracker/data/FinishedBook;", "finishedUpdated", "app_debug"})
    public static abstract interface FinishedHandler {
        
        public abstract void finishedCreated(@org.jetbrains.annotations.NotNull()
        com.example.etta.booktracker.data.FinishedBook item);
        
        public abstract void finishedUpdated(@org.jetbrains.annotations.NotNull()
        com.example.etta.booktracker.data.FinishedBook item);
    }
}