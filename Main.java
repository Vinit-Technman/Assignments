public class Main {
    public static class MediaItem{
        String title;
        int duration;
        String media_type;

        public MediaItem(String title,int duration,String media_type)
        {
            this.title=title;
            this.duration=duration;
            this.media_type=media_type;
        }
        public void display_info(){
            System.out.println("Title: "+title);
            System.out.println("Duration(in minutes): "+duration);
            System.out.println("Media type: "+media_type);
        }
    }

    public static class Book extends MediaItem {
        String Author;

        public Book(String title,int duration,String media_type,String Author)
        {
            super(title,duration,media_type);
            this.Author=Author;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Author: "+Author);
        }
    }
    public static class Movie extends MediaItem {
        String director;

        public Movie(String title,int duration,String media_type,String dir)
        {
            super(title,duration,media_type);
            this.director=dir;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Director: "+director);
        }
    }
    public static class MusicAlbum extends MediaItem {
        String Artist;

        public MusicAlbum(String title,int duration,String media_type,String Artist)
        {
            super(title,duration,media_type);
            this.Artist=Artist;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Artist: "+Artist);
        }
    }


    public static void main(String[] args)
    {
        MediaItem o1=new MediaItem("Animal",200,"Movie");
        o1.display_info();
        System.out.println("------------");
        Book book1=new Book("Animal",200,"Book","A.Livingston");
        book1.display_info();
        System.out.println("------------");

        Movie movie1=new Movie("Animal",200,"Movie","S Reddy");
        movie1.display_info();
        System.out.println("------------");

        MusicAlbum alubm1=new MusicAlbum("T-Series Rewind Repeat S3",100,"Music","Arijit Singh");
        alubm1.display_info();
        System.out.println("------------");
        
    }
}
