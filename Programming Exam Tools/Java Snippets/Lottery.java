public static Integer[] performLottery(int numNumbers, int numbersToPick) {
    List<Integer> numbers = new ArrayList<>();
    for(int i = 0; i < numNumbers; i++) {
        numbers.add(i+1);
    }
    Collections.shuffle(numbers);
    return numbers.subList(0, numbersToPick).toArray(new Integer[numbersToPick]);
}