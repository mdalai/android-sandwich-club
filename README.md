# Sandwich Club Project

## Project Overview
In this project, you will complete the **Sandwich Club** app to
show the details of each sandwich once it is selected.

## Why this Project

Building a layout and populating its fields from data received as JSON
is a common task for Android Developers. Although JSON parsing is usually
done using libraries, writing the JSON parsing for  this project will
help you to better understand how it is processed.

## What I have learned from P0
- I created my own JSON parser from the scratch. See how I did it in details in the post : [Let’s make a JSON Parser](https://medium.com/@mingat.dalai/lets-make-a-json-parser-102382c7a010). The Java version code see here. Even though this code is not recommended, but I did learn a lot by doing. The recommended way of parsing JSON in Android development is JSONObject. 

- The ScrollView is recommended in the layout. Because it makes the app function properly even in a small screen phone. Should put all ImageView, TextView into a ScrollView. 

- The [Picasso](http://square.github.io/picasso/ ) is a powerful image downloading and caching library for Android. This is probably all we need to know. If you interest in knowing more about why Picasso check out [this stackoverflow answers](https://stackoverflow.com/questions/22330772/why-use-android-picasso-library-to-download-images). To use Picasso, need to add dependency in the Gradle: ```implementation 'com.squareup.picasso:picasso:2.5.2'```. The placeholder and error features are available in the Picasso which offers better user experience.
```
Picasso.get()
    .load(url)
    .placeholder(R.drawable.user_placeholder)
    .error(R.drawable.user_placeholder_error)
    .into(imageView);
```

- The code needs to meet API levels requirements. I used ```join()``` to parse the ArrayList values. The problem with this method is it only works with API Levels greater than 26. So I was recommended to adapted more common used method which is ```TextUtils.join()```. 

- Add Back functionality from detail activity to parent activity. Edit AndroidManifest.xml:
```
<activity android:name=".DetailActivity" android:parentActivityName=".MainActivity" />
```

