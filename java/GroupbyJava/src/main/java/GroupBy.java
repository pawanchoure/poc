import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupBy {
    private String ticOrgType;
    private String assetClass;
    private String regionName;

    public GroupBy(String ticOrgType,String assetClass,String regionName){
        super();
        this.ticOrgType=ticOrgType;
        this.assetClass=assetClass;
        this.regionName=regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupBy groupBy = (GroupBy) o;

        if (!ticOrgType.equals(groupBy.ticOrgType)) return false;
        if (!assetClass.equals(groupBy.assetClass)) return false;
        return regionName.equals(groupBy.regionName);
    }

    @Override
    public int hashCode() {
        int result = ticOrgType.hashCode();
        result = 31 * result + assetClass.hashCode();
        result = 31 * result + regionName.hashCode();
        return result;
    }
}
