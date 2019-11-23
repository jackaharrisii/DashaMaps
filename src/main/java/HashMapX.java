public interface HashMapX {
    // fundamentals
    public void set(String key, String value);
    public String delete(String key);
    public String get(String key);
    public boolean isEmpty();
    public long size();

    // testing access
//    protected boolean bucketSize(String key); // used for tests
// not sure what this one does, but it's broken.....

}
