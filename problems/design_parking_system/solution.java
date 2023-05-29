class ParkingSystem {
    int[] empty;

    public ParkingSystem(int big, int medium, int small) {
        empty = new int[]{ big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // If space is available, allocate and return True
        if (this.empty[carType - 1] > 0) {
            this.empty[carType - 1]--;
            return true;
        }

        // Else, return False
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */