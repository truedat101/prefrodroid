/*
 * Prefrodroid - An Android Preferences Activity that allows users to create dynamic 
 * preference items.
 * Written in 2013 by truedat101 @dkords
 *
 * To the extent possible under law, the author(s) have dedicated all copyright and related 
 * and neighboring rights to this software to the public domain worldwide. This software is 
 * distributed without any warranty.
 * You should have received a copy of the CC0 Public Domain Dedication along with this 
 * software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 *
 */
package com.prefrodroid;

import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

import com.prefrodroid.R;


public class PFActivity extends PreferenceActivity {
	protected String mSharedPrefsName;
	protected SharedPreferences mSharedPrefs;
	

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mSharedPrefsName = this.getResources().getString(R.string.app_name);
		PreferenceManager.setDefaultValues (this, mSharedPrefsName, Context.MODE_PRIVATE, R.xml.preferences, false);
		SharedPreferences prefs =  getSharedPreferences(mSharedPrefsName, Context.MODE_PRIVATE);
		if (prefs != null) {
			mSharedPrefs = prefs;
		}
		
		// add the prefernces.xml layout
		addPreferencesFromResource(R.xml.preferences);

		// TODO: See if we can introspect the known list of preferences, and handle them each based on type
		CheckBoxPreference vibratePref = (CheckBoxPreference) findPreference("pf_dfkey_active_vibrate");
		
		// TODO: Come up with some common validators
		
		vibratePref.setOnPreferenceChangeListener(new GenericCheckboxListener("pf_dfkey_active_vibrate" ,true));

		// setContentView(R.layout.main);
	}
	
	protected class GenericCheckboxListener implements Preference.OnPreferenceChangeListener {
		private String mPreferenceKey;
		private boolean mRequired;
		
		public GenericCheckboxListener(String preferenceKey, boolean required) {
			mPreferenceKey = preferenceKey;
			mRequired = required;
		}
		
		
		@Override
		public boolean onPreferenceChange(Preference preference, Object o) {
			preference.setSummary(o.toString());
			SharedPreferences.Editor editor = mSharedPrefs.edit();
			editor.putString(mPreferenceKey, o.toString());
			editor.commit();
			return true;
		}
	}
}