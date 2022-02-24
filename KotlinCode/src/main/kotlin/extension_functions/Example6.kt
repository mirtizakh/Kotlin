package extension_functions



fun String.emojify(value:String)  = "$value party"

/*
 what’s happening is that the compiler is rewriting our extension function to a static function that also takes the
  instance being operated on as a parameter, then renaming that parameter to this. For the curious, the decompiled code looks a bit like the following:
static final String emojify(String $this)
 */