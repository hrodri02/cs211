public enum AnimalStatus {
    NEW(false), 
    TEMPORARY(true), 
    PERMANENT(false);
    
    private boolean isEligibleForAdoption;
    
    private AnimalStatus(boolean isEligibleForAdoption) {
        this.isEligibleForAdoption = isEligibleForAdoption;
    }

    public boolean getIsEligibleForAdoption() {
        return isEligibleForAdoption;
    }
}