prefrodroid
===========

The goal of prefrodroid is to offer a common way to add extensible user preferences to any android app.  The standard PreferenceActivity is a nice start, but for applications that require to allow users to create new preference items dynamically, the existing class doesn't help. 

Requirements
============

* Should provide an activity for users to include in their own apps
* Should not have any external dependencies
* Utilize as much existing Android Preference infrastructure as possible, though it is not strictly required to utilize Preference items in the UI, but should use SharedPreferences in the back end.
* Minimal number of project assets (xml, images, classfiles) to make it easy to import into other projects
* Exportable as a Library Project, for easy inclusion into other projects
* Should be delivered with a very liberal license, allowing projects to relicense or not include my copyright header.  I don't need credit for this.  I intend that anyone with commercial interests can call this code their own.

References
==========

* Android Design Guidelines for Settings https://developer.android.com/design/patterns/settings.html
* A good UI example lives online under CC-BY-SA http://redmine.ccnx.org/attachments/143/ccnx-android-service-prefs-wireframe.png (attribution: PARC)

Roadmap
=======

v0.1.0
________

* Project Template
* Initial Code base
* README contents
* License Added (use CC-Zero)