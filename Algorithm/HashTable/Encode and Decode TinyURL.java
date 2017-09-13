public class Codec {
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    int count = 1;
    HashMap<String, String> map = new HashMap<>();
    public String getString() {
        StringBuilder sb = new StringBuilder();
        //this part is important, it acts like 62-based string
        if (count > 0) {
            int c = count;
            sb.append(chars.charAt(c % 62));
            c /= 62;
        }
        return sb.toString();
    }
    public String encode(String longUrl) {
       String s = getString();
       map.put(s, longUrl);
       return "http://tinyurl.com/" + s;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String s = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
