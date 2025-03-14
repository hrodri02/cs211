import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class IncomeBracket {
    private Integer min;
    private Integer max;
    private String range;
	private List<Integer> ageGroups;
    
    private IncomeBracket(Builder builder) {
        this.min = builder.min;
        this.max = builder.max;
		this.range = builder.range;
		this.ageGroups = builder.ageGroups;
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

    public List<Integer> getAgeGroups() {
        return this.ageGroups;
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

    public void setAgeGroups(List<Integer> ageGroups) {
        this.ageGroups = ageGroups;
    }

    @Override
	public String toString() {
        int total = 0;
        for (Integer numOfFamiliesInAgeGroup: ageGroups) {
            total += numOfFamiliesInAgeGroup;
        }
		return "range =" + range + "\tnumber of families =" + total + "\n";
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof IncomeBracket incomeBracket) &&
            this.range.equals(incomeBracket.getRange()) &&
            this.ageGroups.equals(incomeBracket.getAgeGroups());
    }

    public static class AgeGroupsComparator implements Comparator<IncomeBracket> {
        @Override
        public int compare(IncomeBracket bracket1, IncomeBracket bracket2) {
            Integer numFamiliesInFirstBracket = 0;
            for (Integer numOfFamiliesInAgeGroup : bracket1.ageGroups) {
                numFamiliesInFirstBracket += numOfFamiliesInAgeGroup;
            }

            Integer numFamiliesInSecondBracket = 0;
            for (Integer numOfFamiliesInAgeGroup : bracket2.ageGroups) {
                numFamiliesInSecondBracket += numOfFamiliesInAgeGroup;
            }

            return Integer.compare(numFamiliesInSecondBracket, numFamiliesInFirstBracket);
        }
    }

    public static class Builder {
        private Integer min;
        private Integer max;
		private String range;
		private List<Integer> ageGroups;

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

		public Builder ageGroups(List<Integer> value) {
			ageGroups = value;
			return this;
		}

		public IncomeBracket build() {
			IncomeBracket incomeBracket = new IncomeBracket(this);
			if (min == null || max == null || range == null || ageGroups == null) {
				throw new IllegalStateException("All information about a IncomeBracket must be specified.");
			}
			return incomeBracket;
		}
	}
}
