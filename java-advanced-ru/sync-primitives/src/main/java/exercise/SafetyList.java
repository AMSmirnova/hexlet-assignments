package exercise;

class SafetyList {
    // BEGIN
    private List<Integer> array = new ArrayList<>();

    public synchronized void add(Integer number) {
        array.add(number);
    }

    public Integer get(int index) {
        return array.get(index);
    }
    public int getSize() {
        return array.size();
    }
    // END
}
