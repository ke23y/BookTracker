package com.example.etta.booktracker.data;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {com.example.etta.booktracker.data.FinishedBook.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/etta/booktracker/data/FinishedDataBase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "finishedBookDAO", "Lcom/example/etta/booktracker/data/FinishedBookDAO;", "Companion", "app_debug"})
public abstract class FinishedDataBase extends android.arch.persistence.room.RoomDatabase {
    private static com.example.etta.booktracker.data.FinishedDataBase INSTANCE;
    public static final com.example.etta.booktracker.data.FinishedDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.etta.booktracker.data.FinishedBookDAO finishedBookDAO();
    
    public FinishedDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/etta/booktracker/data/FinishedDataBase$Companion;", "", "()V", "INSTANCE", "Lcom/example/etta/booktracker/data/FinishedDataBase;", "destroyInstance", "", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.etta.booktracker.data.FinishedDataBase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
        
        private Companion() {
            super();
        }
    }
}