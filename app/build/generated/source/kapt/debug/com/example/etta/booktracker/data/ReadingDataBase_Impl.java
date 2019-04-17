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
public class ReadingDataBase_Impl extends ReadingDataBase {
  private volatile ReadingBookDAO _readingBookDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `readingbook` (`itemID` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `done` INTEGER, `language` TEXT, `desire` INTEGER NOT NULL, `subject` TEXT, `ISBN-13` TEXT, `page` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"de885cb196b4a155bb74d002c40aea77\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `readingbook`");
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
        final HashMap<String, TableInfo.Column> _columnsReadingbook = new HashMap<String, TableInfo.Column>(9);
        _columnsReadingbook.put("itemID", new TableInfo.Column("itemID", "INTEGER", false, 1));
        _columnsReadingbook.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsReadingbook.put("author", new TableInfo.Column("author", "TEXT", true, 0));
        _columnsReadingbook.put("done", new TableInfo.Column("done", "INTEGER", false, 0));
        _columnsReadingbook.put("language", new TableInfo.Column("language", "TEXT", false, 0));
        _columnsReadingbook.put("desire", new TableInfo.Column("desire", "INTEGER", true, 0));
        _columnsReadingbook.put("subject", new TableInfo.Column("subject", "TEXT", false, 0));
        _columnsReadingbook.put("ISBN-13", new TableInfo.Column("ISBN-13", "TEXT", false, 0));
        _columnsReadingbook.put("page", new TableInfo.Column("page", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReadingbook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReadingbook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReadingbook = new TableInfo("readingbook", _columnsReadingbook, _foreignKeysReadingbook, _indicesReadingbook);
        final TableInfo _existingReadingbook = TableInfo.read(_db, "readingbook");
        if (! _infoReadingbook.equals(_existingReadingbook)) {
          throw new IllegalStateException("Migration didn't properly handle readingbook(com.example.etta.booktracker.data.ReadingBook).\n"
                  + " Expected:\n" + _infoReadingbook + "\n"
                  + " Found:\n" + _existingReadingbook);
        }
      }
    }, "de885cb196b4a155bb74d002c40aea77", "3473d7be10ce4b6292a3ba4d0ffb1598");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "readingbook");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `readingbook`");
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
  public ReadingBookDAO readingBookDAO() {
    if (_readingBookDAO != null) {
      return _readingBookDAO;
    } else {
      synchronized(this) {
        if(_readingBookDAO == null) {
          _readingBookDAO = new ReadingBookDAO_Impl(this);
        }
        return _readingBookDAO;
      }
    }
  }
}
