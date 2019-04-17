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
public class ReadingBookDAO_Impl implements ReadingBookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfReadingBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfReadingBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfReadingBook;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ReadingBookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReadingBook = new EntityInsertionAdapter<ReadingBook>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `readingbook`(`itemID`,`name`,`author`,`done`,`language`,`desire`,`subject`,`ISBN-13`,`page`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReadingBook value) {
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
        if (value.getCurrentPage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCurrentPage());
        }
      }
    };
    this.__deletionAdapterOfReadingBook = new EntityDeletionOrUpdateAdapter<ReadingBook>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `readingbook` WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReadingBook value) {
        if (value.getItemID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getItemID());
        }
      }
    };
    this.__updateAdapterOfReadingBook = new EntityDeletionOrUpdateAdapter<ReadingBook>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `readingbook` SET `itemID` = ?,`name` = ?,`author` = ?,`done` = ?,`language` = ?,`desire` = ?,`subject` = ?,`ISBN-13` = ?,`page` = ? WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ReadingBook value) {
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
        if (value.getCurrentPage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCurrentPage());
        }
        if (value.getItemID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getItemID());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM readingbook";
        return _query;
      }
    };
  }

  @Override
  public long insertItem(ReadingBook item) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfReadingBook.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(ReadingBook item) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfReadingBook.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateItem(ReadingBook item) {
    __db.beginTransaction();
    try {
      __updateAdapterOfReadingBook.handle(item);
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
  public List<ReadingBook> findAllItems() {
    final String _sql = "SELECT * FROM readingbook";
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
      final int _cursorIndexOfCurrentPage = _cursor.getColumnIndexOrThrow("page");
      final List<ReadingBook> _result = new ArrayList<ReadingBook>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ReadingBook _item;
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
        final String _tmpCurrentPage;
        _tmpCurrentPage = _cursor.getString(_cursorIndexOfCurrentPage);
        _item = new ReadingBook(_tmpItemID,_tmpBookName,_tmpAuthor,_tmpDone,_tmpLanguage,_tmpDesire,_tmpSubject,_tmpIsbn,_tmpCurrentPage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
