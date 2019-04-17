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
public class FinishedDataBase_Impl extends FinishedDataBase {
  private volatile FinishedBookDAO _finishedBookDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `finishedbook` (`itemID` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `author` TEXT NOT NULL, `done` INTEGER, `language` TEXT, `desire` INTEGER NOT NULL, `subject` TEXT, `ISBN-13` TEXT, `startdate` TEXT, `enddate` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b7340fdb5caffc41820a242c76dbf826\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `finishedbook`");
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
        final HashMap<String, TableInfo.Column> _columnsFinishedbook = new HashMap<String, TableInfo.Column>(10);
        _columnsFinishedbook.put("itemID", new TableInfo.Column("itemID", "INTEGER", false, 1));
        _columnsFinishedbook.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsFinishedbook.put("author", new TableInfo.Column("author", "TEXT", true, 0));
        _columnsFinishedbook.put("done", new TableInfo.Column("done", "INTEGER", false, 0));
        _columnsFinishedbook.put("language", new TableInfo.Column("language", "TEXT", false, 0));
        _columnsFinishedbook.put("desire", new TableInfo.Column("desire", "INTEGER", true, 0));
        _columnsFinishedbook.put("subject", new TableInfo.Column("subject", "TEXT", false, 0));
        _columnsFinishedbook.put("ISBN-13", new TableInfo.Column("ISBN-13", "TEXT", false, 0));
        _columnsFinishedbook.put("startdate", new TableInfo.Column("startdate", "TEXT", false, 0));
        _columnsFinishedbook.put("enddate", new TableInfo.Column("enddate", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFinishedbook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFinishedbook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFinishedbook = new TableInfo("finishedbook", _columnsFinishedbook, _foreignKeysFinishedbook, _indicesFinishedbook);
        final TableInfo _existingFinishedbook = TableInfo.read(_db, "finishedbook");
        if (! _infoFinishedbook.equals(_existingFinishedbook)) {
          throw new IllegalStateException("Migration didn't properly handle finishedbook(com.example.etta.booktracker.data.FinishedBook).\n"
                  + " Expected:\n" + _infoFinishedbook + "\n"
                  + " Found:\n" + _existingFinishedbook);
        }
      }
    }, "b7340fdb5caffc41820a242c76dbf826", "1608587da3580d309f59d8c544373830");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "finishedbook");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `finishedbook`");
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
  public FinishedBookDAO finishedBookDAO() {
    if (_finishedBookDAO != null) {
      return _finishedBookDAO;
    } else {
      synchronized(this) {
        if(_finishedBookDAO == null) {
          _finishedBookDAO = new FinishedBookDAO_Impl(this);
        }
        return _finishedBookDAO;
      }
    }
  }
}
