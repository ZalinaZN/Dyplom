import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngineMap {
    private final Map<String, List<SearchEnginePDF>> searchEngineMap;

    public SearchEngineMap() {
        this.searchEngineMap = new HashMap<>();
    }

    public Map<String, List<SearchEnginePDF>> getSearchEngineMap() {
        return searchEngineMap;
    }

    public void searchEngineMapAdd(String word, SearchEnginePDF entry) {
        List<SearchEnginePDF> searchEngineArray = new ArrayList<>();
        if (searchEngineMap.containsKey(word)) {
            searchEngineArray = searchEngineMap.get(word);
        }
        searchEngineArray.add(entry);
        searchEngineMap.put(word, searchEngineArray);
    }

    @Override
    public String toString() {
        return "SearchEngineMap{" +
                "searchEngineMap =" + searchEngineMap +
                '}';
    }
}
