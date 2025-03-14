import java.util.List;

public class IncomeBracket implements Comparable<IncomeBracket> {
    private Integer min;
    private Integer max;
    private String range;
	private List<Integer> numOfFamiliesInAgeGroups;
    
    private IncomeBracket(Builder builder) {
        this.min = builder.min;
        this.max = builder.max;
		this.range = builder.range;
		this.numOfFamiliesInAgeGroups = builder.numOfFamiliesInAgeGroups;
	}

    public Integer getMin() {
        return this.min;
    }

    public Integer getMax() {
        return this.max;
    }

    public String getRange() {
        return this.range;
    }

    public List<Integer> getNumOfFamiliesInAgeGroups() {
        return this.numOfFamiliesInAgeGroups;
    }

    public Integer getTotalNumOfFamilies() {
        Integer total = 0;
        for (Integer familiesInAgeGroup : numOfFamiliesInAgeGroups) {
            total += familiesInAgeGroup;
        }
        return total;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setNumOfFamiliesInAgeGroups(List<Integer> numOfFamiliesInAgeGroups) {
        this.numOfFamiliesInAgeGroups = numOfFamiliesInAgeGroups;
    }

    @Override
	public String toString() {
        int total = getTotalNumOfFamilies();
		return "range =" + range + "\tnumber of families =" + total;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof IncomeBracket incomeBracket) &&
            this.range.equals(incomeBracket.getRange()) &&
            this.numOfFamiliesInAgeGroups.equals(incomeBracket.getNumOfFamiliesInAgeGroups());
    }

    @Override
    public int compareTo(IncomeBracket otherBracket) {
        Integer numFamiliesInFirstBracket = 0;
        for (Integer numOfFamiliesInAgeGroup : this.numOfFamiliesInAgeGroups) {
            numFamiliesInFirstBracket += numOfFamiliesInAgeGroup;
        }

        Integer numFamiliesInSecondBracket = 0;
        for (Integer numOfFamiliesInAgeGroup : otherBracket.numOfFamiliesInAgeGroups) {
            numFamiliesInSecondBracket += numOfFamiliesInAgeGroup;
        }

        return Integer.compare(numFamiliesInSecondBracket, numFamiliesInFirstBracket);
    }

    public static class Builder {
        private Integer min;
        private Integer max;
		private String range;
		private List<Integer> numOfFamiliesInAgeGroups;

		public Builder() { 	}

        public Builder min(Integer value) {
			min = value;
			return this;
		}

        public Builder max(Integer value) {
			max = value;
			return this;
		}

		public Builder range(String value) {
			range = value;
			return this;
		}

		public Builder numOfFamiliesInAgeGroups(List<Integer> value) {
			numOfFamiliesInAgeGroups = value;
			return this;
		}

		public IncomeBracket build() {
			IncomeBracket incomeBracket = new IncomeBracket(this);
			if (min == null || max == null || range == null || numOfFamiliesInAgeGroups == null) {
				throw new IllegalStateException("All information about a IncomeBracket must be specified.");
			}
			return incomeBracket;
		}
	}
}
