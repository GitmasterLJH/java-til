interface Parsealbe{
    // 구문 분석작업을 수행한다
    public abstract void parse(String fileName);
}
class ParserManger{
    // 리턴타입이 Parseable인터페이스이다.
    public static Parsealbe getParser(String type){
            if(type.equals("XML")){
                 return new XMLParser();
        }else{
            return new HTMLParser();
        }
    }
}
class XMLParser implements Parsealbe{
    public void parse(String fileName){
        System.out.println(fileName+"-XML parsing completed.");
    }
}
class HTMLParser implements Parsealbe{
    public void parse(String fileName){
        System.out.println(fileName+"-HTML parsing completed.");
    }
}
class ParseTest{
    public static void main(String[] args) {
        Parsealbe parser = ParserManger.getParser("XML");
        parser.parse("document.xml");
        parser = ParserManger.getParser("HTML");
        parser.parse("document2.html");
    }
}