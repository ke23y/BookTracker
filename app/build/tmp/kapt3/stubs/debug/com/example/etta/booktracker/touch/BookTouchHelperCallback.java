package com.example.etta.booktracker.touch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/etta/booktracker/touch/BookTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "bookTouchHelperAdapter", "Lcom/example/etta/booktracker/touch/BookTouchHelperAdapter;", "(Lcom/example/etta/booktracker/touch/BookTouchHelperAdapter;)V", "getMovementFlags", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onMove", "target", "onSwiped", "", "direction", "app_debug"})
public final class BookTouchHelperCallback extends android.support.v7.widget.helper.ItemTouchHelper.Callback {
    private final com.example.etta.booktracker.touch.BookTouchHelperAdapter bookTouchHelperAdapter = null;
    
    @java.lang.Override()
    public boolean isLongPressDragEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isItemViewSwipeEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public int getMovementFlags(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        return 0;
    }
    
    @java.lang.Override()
    public boolean onMove(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder target) {
        return false;
    }
    
    @java.lang.Override()
    public void onSwiped(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int direction) {
    }
    
    public BookTouchHelperCallback(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.touch.BookTouchHelperAdapter bookTouchHelperAdapter) {
        super();
    }
}