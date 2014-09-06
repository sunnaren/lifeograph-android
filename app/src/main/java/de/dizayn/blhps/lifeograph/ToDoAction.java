/***********************************************************************************

 Copyright (C) 2012-2014 Ahmet Öztürk (aoz_2@yahoo.com)

 This file is part of Lifeograph.

 Lifeograph is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Lifeograph is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Lifeograph.  If not, see <http://www.gnu.org/licenses/>.

 ***********************************************************************************/


package de.dizayn.blhps.lifeograph;

import android.content.Context;
import android.util.Log;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ToDoAction extends ActionProvider implements MenuItem.OnMenuItemClickListener
{
    public ToDoAction( Context context ) {
        super( context );
        mContext = context;
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public void onPrepareSubMenu( SubMenu menu ) {
        super.onPrepareSubMenu( menu );

        menu.clear();

        menu.add( 0, R.id.todo_not, 0, R.string.todo_not )
                .setOnMenuItemClickListener( this );

        menu.add( 0, R.id.todo_open, 1, R.string.todo_open )
                .setIcon( R.drawable.ic_todo_open )
                .setOnMenuItemClickListener( this );

        menu.add( 0, R.id.todo_done, 1, R.string.todo_done )
                .setIcon( R.drawable.ic_todo_done )
                .setOnMenuItemClickListener( this );

        menu.add( 0, R.id.todo_canceled, 1, R.string.todo_canceled )
                .setIcon( R.drawable.ic_todo_canceled )
                .setOnMenuItemClickListener( this );
    }

    //@Override
    public boolean onMenuItemClick( MenuItem item ) {
        switch( item.getItemId() )
        {
            case android.R.id.home:
                return true;
            case R.id.todo_not:
                Log.d( Lifeograph.TAG, "not todo" );
                mObject.set_todo_status( DiaryElement.ES_NOT_TODO );
                return true;
            case R.id.todo_open:
                Log.d( Lifeograph.TAG, "open" );
                mObject.set_todo_status( DiaryElement.ES_TODO );
                return true;
            case R.id.todo_done:
                Log.d( Lifeograph.TAG, "done" );
                mObject.set_todo_status( DiaryElement.ES_DONE );
                return true;
            case R.id.todo_canceled:
                Log.d( Lifeograph.TAG, "canceled" );
                mObject.set_todo_status( DiaryElement.ES_CANCELED );
                return true;
        }
        return true;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    public interface ToDoObject {
        public void set_todo_status( int s );
    }

    protected Context mContext; // not used now
    public static ToDoObject mObject;
}