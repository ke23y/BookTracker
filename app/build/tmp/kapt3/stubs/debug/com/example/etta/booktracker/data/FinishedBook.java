package com.example.etta.booktracker.data;

import java.lang.System;

@android.arch.persistence.room.Entity(tableName = "finishedbook")
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010%J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000b\u00104\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0080\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010=H\u00d6\u0003J\t\u0010>\u001a\u00020\u000bH\u00d6\u0001J\t\u0010?\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014\u00a8\u0006@"}, d2 = {"Lcom/example/etta/booktracker/data/FinishedBook;", "Ljava/io/Serializable;", "itemID", "", "bookName", "", "author", "done", "", "language", "desire", "", "subject", "isbn", "startDate", "endDate", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "getBookName", "setBookName", "getDesire", "()I", "setDesire", "(I)V", "getDone", "()Ljava/lang/Boolean;", "setDone", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndDate", "setEndDate", "getIsbn", "setIsbn", "getItemID", "()Ljava/lang/Long;", "setItemID", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLanguage", "setLanguage", "getStartDate", "setStartDate", "getSubject", "setSubject", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/example/etta/booktracker/data/FinishedBook;", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class FinishedBook implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.PrimaryKey(autoGenerate = true)
    private java.lang.Long itemID;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "name")
    private java.lang.String bookName;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.ColumnInfo(name = "author")
    private java.lang.String author;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "done")
    private java.lang.Boolean done;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "language")
    private java.lang.String language;
    @android.arch.persistence.room.ColumnInfo(name = "desire")
    private int desire;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "subject")
    private java.lang.String subject;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "ISBN-13")
    private java.lang.String isbn;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "startdate")
    private java.lang.String startDate;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "enddate")
    private java.lang.String endDate;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getItemID() {
        return null;
    }
    
    public final void setItemID(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBookName() {
        return null;
    }
    
    public final void setBookName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    public final void setAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getDone() {
        return null;
    }
    
    public final void setDone(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getDesire() {
        return 0;
    }
    
    public final void setDesire(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubject() {
        return null;
    }
    
    public final void setSubject(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIsbn() {
        return null;
    }
    
    public final void setIsbn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStartDate() {
        return null;
    }
    
    public final void setStartDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEndDate() {
        return null;
    }
    
    public final void setEndDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public FinishedBook(@org.jetbrains.annotations.Nullable()
    java.lang.Long itemID, @org.jetbrains.annotations.NotNull()
    java.lang.String bookName, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean done, @org.jetbrains.annotations.Nullable()
    java.lang.String language, int desire, @org.jetbrains.annotations.Nullable()
    java.lang.String subject, @org.jetbrains.annotations.Nullable()
    java.lang.String isbn, @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.etta.booktracker.data.FinishedBook copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long itemID, @org.jetbrains.annotations.NotNull()
    java.lang.String bookName, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean done, @org.jetbrains.annotations.Nullable()
    java.lang.String language, int desire, @org.jetbrains.annotations.Nullable()
    java.lang.String subject, @org.jetbrains.annotations.Nullable()
    java.lang.String isbn, @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}