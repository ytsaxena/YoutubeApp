package android.demo.searchyt2.models;

import java.util.List;

public class LiveResponseModel {

   private String  kind;
   private String etag;
   private String nextPageToken;
    private String regionCode;
    private pageInfo pageInfo;
    private List<items> items;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public android.demo.searchyt2.models.pageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(android.demo.searchyt2.models.pageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<android.demo.searchyt2.models.items> getItems() {
        return items;
    }

    public void setItems(List<android.demo.searchyt2.models.items> items) {
        this.items = items;
    }
}
