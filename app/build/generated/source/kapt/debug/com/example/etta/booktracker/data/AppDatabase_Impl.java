package com.example.etta.booktracker.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile BookDAO _bookDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `book` (`itemID` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `done` INTEGER, `language` TEXT, `desire` INTEGER NOT NULL, `subject` TEXT, `ISBN-13` TEXT, `startdate` TEXT, `finishDate` TEXT, `page` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"8955352e018c238711e769189e9c9cc3\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `book`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBook = new HashMap<String, TableInfo.Column>(11);
        _columnsBook.put("itemID", new TableInfo.Column("itemID", "INTEGER", false, 1));
        _columnsBook.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsBook.put("author", new TableInfo.Column("author", "TEXT", true, 0));
        _columnsBook.put("done", new TableInfo.Column("done", "INTEGER", false, 0));
        _columnsBook.put("language", new TableInfo.Column("language", "TEXT", false, 0));
        _columnsBook.put("desire", new TableInfo.Column("desire", "INTEGER", true, 0));
        _columnsBook.put("subject", new TableInfo.Column("subject", "TEXT", false, 0));
        _columnsBook.put("ISBN-13", new TableInfo.Column("ISBN-13", "TEXT", false, 0));
        _columnsBook.put("startdate", new TableInfo.Column("startdate", "TEXT", false, 0));
        _columnsBook.put("finishDate", new TableInfo.Column("finishDate", "TEXT", false, 0));
        _columnsBook.put("page", new TableInfo.Column("page", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBook = new TableInfo("book", _columnsBook, _foreignKeysBook, _indicesBook);
        final TableInfo _existingBook = TableInfo.read(_db, "book");
        if (! _infoBook.equals(_existingBook)) {
          throw new IllegalStateException("Migration didn't properly handle book(com.example.etta.booktracker.data.Book).\n"
                  + " Expected:\n" + _infoBook + "\n"
                  + " Found:\n" + _existingBook);
        }
      }
    }, "8955352e018c238711e769189e9c9cc3", "b00de5af4a56d3bae8f8129bade68e7e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "book");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `book`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BookDAO bookDAO() {
    if (_bookDAO != null) {
      return _bookDAO;
    } else {
      synchronized(this) {
        if(_bookDAO == null) {
          _bookDAO = new BookDAO_Impl(this);
        }
        return _bookDAO;
      }
    }
  }
}
