package week5_1;

import java.util.Random;

public class Word {
    private String[] WordList = new String[]{"Adobe", "Acrobat", "Address", "Algorithm", "AMD", "Android", "API", "Apple",
            "Boland", "binary", "BIOS", "bitcoi", "byte", "Botnet",
            "CPU" , "Cisco", "Cloud", "client", "css", "Chrome",
            "data", "database", "Debian", "decompress", "desktop", "dialer", "digital", "document", "download",
            "electricity", "email", "Explorer",
            "Fedora", "file", "filesharing", "filesystem", "firewall", "folder", "footnotes", "format", "FreeBSD", "freeware", "FTP", "Facebook",
            "gigabyte", "Gimp", "Gmail", "Gnome", "Google", "GNU", "GnuPG", "GPU", "GitHub",
            "hacker", "hardware", "HDMI", "HTML", "HTTP",
            "Intel",
            "Java", "JavaScript",
            "kernel", "keyboard", "key", "keyword",
            "laptop", "link", "Linux", "Lavasoft",
            "Macintosh", "Malware", "Martus", "media", "megabyte", "Microsoft", "modify", "monitor", "Motherboard", "mouse", "Modem",
            "Netscape", "network", "Nvidia",
            "ogg",
            "page", "Perl", "Petabyte", "PGP", "PHP", "proprietary", "piracy", "pirate", "printer", "privacy", "program", "Python",
            "QNX", "QuickBasic", "QuickTime",
            "ReactOS", "RedHat", "root", "RSA",
            "scan", "security", "server", "shareware", "software", "spam", "spamming", "Spreadsheet", "spyware", "Suse", "SDK", "SSD",
            "Terabyte",
            "undo", "UNIX", "update", "upload", "user", "USB",
            "version", "virus", "Vulnerability",
            "Windows",
            "Xine", "XML",
            "Yotabyte",
            "ZIP"
    };
    private String theWord;
    Word(){
        Random R = new Random();
        theWord = WordList[R.nextInt(WordList.length)];
    }

    public String getTheWord() {
        return theWord;
    }
}
