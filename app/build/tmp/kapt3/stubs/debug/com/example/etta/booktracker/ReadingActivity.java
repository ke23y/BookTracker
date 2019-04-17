package com.example.etta.booktracker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0016\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/etta/booktracker/ReadingActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/example/etta/booktracker/dialogues/DialogueReading$ReadingHandler;", "()V", "editIndex", "", "readingAdapter", "Lcom/example/etta/booktracker/Adapter/ReadingAdapter;", "deleteAll", "", "initRecyclerView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "openFinishedList", "openToReadList", "readingCreated", "Lcom/example/etta/booktracker/data/ReadingBook;", "readingUpdated", "setUpDrawer", "showItem", "showReadingDialog", "itemToEdit", "idx", "Companion", "app_debug"})
public final class ReadingActivity extends android.support.v7.app.AppCompatActivity implements com.example.etta.booktracker.dialogues.DialogueReading.ReadingHandler {
    private com.example.etta.booktracker.Adapter.ReadingAdapter readingAdapter;
    private int editIndex;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String READING_BOOK_TO_EDIT = "READING_BOOK_TO_EDIT";
    public static final com.example.etta.booktracker.ReadingActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpDrawer() {
    }
    
    /**
     * Called when the user taps Reading button  button 
     */
    private final void openToReadList() {
    }
    
    private final void openFinishedList() {
    }
    
    private final void initRecyclerView() {
    }
    
    public final void showReadingDialog(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook itemToEdit, int idx) {
    }
    
    @java.lang.Override()
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    private final void showItem() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void readingCreated(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook item) {
    }
    
    @java.lang.Override()
    public void readingUpdated(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook item) {
    }
    
    private final void deleteAll() {
    }
    
    public ReadingActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/etta/booktracker/ReadingActivity$Companion;", "", "()V", "READING_BOOK_TO_EDIT", "", "getREADING_BOOK_TO_EDIT", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getREADING_BOOK_TO_EDIT() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}