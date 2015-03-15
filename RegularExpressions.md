1a. If you're using the same pattern repeatedly, create a Pattern ONCE:
```
Pattern p = Pattern.compile("MyPattern");
```
1b. Otherwise, use matches:
```
boolean b = Pattern.matches("MyPattern", "MySearchString");
```
Or even String's matches();

2. Assuming 1(a), create a Matcher for the String you are comparing:
```
Matcher m = p.matcher("MySearchString");
```

3. Then call the appropriate function to see if we match:
```
boolean m.matches() // whole string matches pattern
boolean m.find()    // substring matches pattern, can be called repeatedly
String  m.group()   // use in combination with find() to get the chars that match
```

4. Alternatively, call split() to get an array of strings:
```
String s[] = p.split("MySearchString");
```

# Expression Syntax #

```
\n       new line
[abcd]   any of a b c or d
[^abcd]  anything but a, b, c or d
[1-9]    anything in the range of chars 1 to 9.
.        any single character
+        1 or more
*        0 or more
?        zero or one
+?       find the narrowest range, rather than the largest
```

# Groups #

Use () to capture groups, then pass the group number to the group() function to get the group you are after, where 0 is the whole expression.