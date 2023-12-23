import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicBDrillDownData {

    private String ticOrgType;
    private String assetClass;
    private String regionName;
    private Integer countryId;
    private Double filingValueUsd;
    private Double filingValueUsdMillion;
    private Boolean isEcpBank;
    private Boolean isOwnForeignEntity;
    private String currencyName;
    private GroupBy groupBy;

    public TicBDrillDownData(String ticOrgType, String assetClass, String regionName, int countryId, Double filingValueUsd, Double filingValueUsdMillion, String currencyName) {
        this.ticOrgType = ticOrgType;
        this.assetClass = assetClass;
        this.regionName = regionName;
        this.countryId = countryId;
        this.filingValueUsd = filingValueUsd;
        this.currencyName = currencyName;
        this.filingValueUsdMillion = filingValueUsdMillion;


    }

    public TicBDrillDownData() {

    }

    public Double getValue(String name) {
        if (name == "filingValueUsd") {
            return filingValueUsd;
        }
        if (name == "filingValueUsdMillion")
            return filingValueUsdMillion;

        return null;
    }

}
