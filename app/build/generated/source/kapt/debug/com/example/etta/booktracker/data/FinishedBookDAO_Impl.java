package com.example.etta.booktracker.data;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FinishedBookDAO_Impl implements FinishedBookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfFinishedBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFinishedBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfFinishedBook;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FinishedBookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFinishedBook = new EntityInsertionAdapter<FinishedBook>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `finishedbook`(`itemID`,`name`,`author`,`done`,`language`,`desire`,`subject`,`ISBN-13`,`startdate`,`enddate`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinishedBook value) {
        if (value.getItemID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getItemID());
        }
        if (value.getBookName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBookName());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthor());
        }
        final Integer _tmp;
        _tmp = value.getDone() == null ? null : (value.getDone() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindLong(6, value.getDesire());
        if (value.getSubject() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSubject());
        }
        if (value.getIsbn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIsbn());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDate());
        }
      }
    };
    this.__deletionAdapterOfFinishedBook = new EntityDeletionOrUpdateAdapter<FinishedBook>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `finishedbook` WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinishedBook value) {
        if (value.getItemID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getItemID());
        }
      }
    };
    this.__updateAdapterOfFinishedBook = new EntityDeletionOrUpdateAdapter<FinishedBook>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `finishedbook` SET `itemID` = ?,`name` = ?,`author` = ?,`done` = ?,`language` = ?,`desire` = ?,`subject` = ?,`ISBN-13` = ?,`startdate` = ?,`enddate` = ? WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FinishedBook value) {
        if (value.getItemID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getItemID());
        }
        if (value.getBookName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBookName());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthor());
        }
        final Integer _tmp;
        _tmp = value.getDone() == null ? null : (value.getDone() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindLong(6, value.getDesire());
        if (value.getSubject() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSubject());
        }
        if (value.getIsbn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIsbn());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEndDate());
        }
        if (value.getItemID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getItemID());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM finishedbook";
        return _query;
      }
    };
  }

  @Override
  public long insertItem(FinishedBook item) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfFinishedBook.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(FinishedBook item) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfFinishedBook.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateItem(FinishedBook item) {
    __db.beginTransaction();
    try {
      __updateAdapterOfFinishedBook.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<FinishedBook> findAllItems() {
    final String _sql = "SELECT * FROM finishedbook";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfItemID = _cursor.getColumnIndexOrThrow("itemID");
      final int _cursorIndexOfBookName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfAuthor = _cursor.getColumnIndexOrThrow("author");
      final int _cursorIndexOfDone = _cursor.getColumnIndexOrThrow("done");
      final int _cursorIndexOfLanguage = _cursor.getColumnIndexOrThrow("language");
      final int _cursorIndexOfDesire = _cursor.getColumnIndexOrThrow("desire");
      final int _cursorIndexOfSubject = _cursor.getColumnIndexOrThrow("subject");
      final int _cursorIndexOfIsbn = _cursor.getColumnIndexOrThrow("ISBN-13");
      final int _cursorIndexOfStartDate = _cursor.getColumnIndexOrThrow("startdate");
      final int _cursorIndexOfEndDate = _cursor.getColumnIndexOrThrow("enddate");
      final List<FinishedBook> _result = new ArrayList<FinishedBook>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FinishedBook _item;
        final Long _tmpItemID;
        if (_cursor.isNull(_cursorIndexOfItemID)) {
          _tmpItemID = null;
        } else {
          _tmpItemID = _cursor.getLong(_cursorIndexOfItemID);
        }
        final String _tmpBookName;
        _tmpBookName = _cursor.getString(_cursorIndexOfBookName);
        final String _tmpAuthor;
        _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
        final Boolean _tmpDone;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfDone)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfDone);
        }
        _tmpDone = _tmp == null ? null : _tmp != 0;
        final String _tmpLanguage;
        _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
        final int _tmpDesire;
        _tmpDesire = _cursor.getInt(_cursorIndexOfDesire);
        final String _tmpSubject;
        _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
        final String _tmpIsbn;
        _tmpIsbn = _cursor.getString(_cursorIndexOfIsbn);
        final String _tmpStartDate;
        _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        final String _tmpEndDate;
        _tmpEndDate = _cursor.getString(_cursorIndexOfEndDate);
        _item = new FinishedBook(_tmpItemID,_tmpBookName,_tmpAuthor,_tmpDone,_tmpLanguage,_tmpDesire,_tmpSubject,_tmpIsbn,_tmpStartDate,_tmpEndDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
