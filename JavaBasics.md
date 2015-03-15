
```
javac         to compile
java          to run

Filename must match public class within file

%             modulus symbol
& |           eagerly evaluated conjunctors (as opposed to && ||)
^             xor
& | ^ ~       bitwise operators if applied to int

Shifting:
>>>           unsigned bitwise shift, fills with zeros
>>            signed bitwise shift, maintaining sign
Works on int and long types.
Both operands: Promotion to an int for smaller values.
Result type comes from left operand.
If shifting an int, only the 5 least significant bits of the right hand operand are used; similarly 6 for long.

do ... while  lesser used loop

labelling a block can also be used with break / continue

StringBuffer  mutable string
StringBuilder more eficient, but not thread-safe

this          can be used to call a constructor from another

public static void main (String[] args)
java MyClass "param 1"

private -- default -- protected -- public
more privileges ->
so ... protected = subclasses + package + within class
   ... default == package

interfaces:
- EXTEND (many) other interfaces
- constants are static (and final)
- private and protected NOT allowed, public optional

Abstract methods cannot be private

Java is a PASS BY VALUE language
```