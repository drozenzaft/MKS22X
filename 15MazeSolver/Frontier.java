public interface Frontier {
    public void add(Location coord);
    public Location next();
    public int size();
}
