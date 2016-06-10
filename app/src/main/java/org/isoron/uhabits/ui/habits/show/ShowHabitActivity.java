/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.ui.habits.show;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import org.isoron.uhabits.HabitsApplication;
import org.isoron.uhabits.R;
import org.isoron.uhabits.models.Habit;
import org.isoron.uhabits.models.HabitList;
import org.isoron.uhabits.ui.BaseActivity;

import javax.inject.Inject;

/**
 * Activity that allows the user to see more information about a single habit.
 * Shows all the metadata for the habit, in addition to several charts.
 */
public class ShowHabitActivity extends BaseActivity
{
    private Habit habit;

    @Inject
    HabitList habitList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        HabitsApplication.getComponent().inject(this);

        Uri data = getIntent().getData();
        habit = habitList.getById(ContentUris.parseId(data));

        setContentView(R.layout.show_habit_activity);
//        setupSupportActionBar(true);
        setupHabitActionBar();
    }

    public void setupHabitActionBar()
    {
        if (habit == null) return;

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;

        actionBar.setTitle(habit.getName());
//        setupActionBarColor(ColorUtils.getColor(this, habit.color));
    }

    public Habit getHabit()
    {
        return habit;
    }
}
