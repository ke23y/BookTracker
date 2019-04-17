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
public class BookDAO_Impl implements BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBook;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `book`(`itemID`,`name`,`author`,`done`,`language`,`desire`,`subject`,`ISBN-13`,`startdate`,`finishDate`,`page`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
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
        if (value.getFinishDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFinishDate());
        }
        if (value.getCurrentPage() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCurrentPage());
        }
      }
    };
    this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `book` WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getItemID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getItemID());
        }
      }
    };
    this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `book` SET `itemID` = ?,`name` = ?,`author` = ?,`done` = ?,`language` = ?,`desire` = ?,`subject` = ?,`ISBN-13` = ?,`startdate` = ?,`finishDate` = ?,`page` = ? WHERE `itemID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
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
        if (value.getFinishDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFinishDate());
        }
        if (value.getCurrentPage() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCurrentPage());
        }
        if (value.getItemID() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getItemID());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM book";
        return _query;
      }
    };
  }

  @Override
  public long insertItem(Book item) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfBook.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(Book item) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBook.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateItem(Book item) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBook.handle(item);
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
  public List<Book> findAllItems() {
    final String _sql = "SELECT * FROM book";
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
      final int _cursorIndexOfFinishDate = _cursor.getColumnIndexOrThrow("finishDate");
      final int _cursorIndexOfCurrentPage = _cursor.getColumnIndexOrThrow("page");
      final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Book _item;
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
        final String _tmpFinishDate;
        _tmpFinishDate = _cursor.getString(_cursorIndexOfFinishDate);
        final String _tmpCurrentPage;
        _tmpCurrentPage = _cursor.getString(_cursorIndexOfCurrentPage);
        _item = new Book(_tmpItemID,_tmpBookName,_tmpAuthor,_tmpDone,_tmpLanguage,_tmpDesire,_tmpSubject,_tmpIsbn,_tmpStartDate,_tmpFinishDate,_tmpCurrentPage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
