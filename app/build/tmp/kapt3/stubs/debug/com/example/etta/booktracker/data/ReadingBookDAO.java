package com.example.etta.booktracker.data;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/etta/booktracker/data/ReadingBookDAO;", "", "deleteAll", "", "deleteItem", "item", "Lcom/example/etta/booktracker/data/ReadingBook;", "findAllItems", "", "insertItem", "", "updateItem", "app_debug"})
public abstract interface ReadingBookDAO {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM readingbook")
    public abstract java.util.List<com.example.etta.booktracker.data.ReadingBook> findAllItems();
    
    @android.arch.persistence.room.Insert()
    public abstract long insertItem(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook item);
    
    @android.arch.persistence.room.Delete()
    public abstract void deleteItem(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook item);
    
    @android.arch.persistence.room.Update()
    public abstract void updateItem(@org.jetbrains.annotations.NotNull()
    com.example.etta.booktracker.data.ReadingBook item);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM readingbook")
    public abstract void deleteAll();
}