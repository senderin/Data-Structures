using System;
using System.Collections.Generic;
using System.IO;

namespace Graph_Implementation
{
    public class File
    {

        public StreamReader stream;

        private string fileName;
        private bool hasColumnLine;

        public File(string fileName, bool hasColumnNameLine)
        {
            this.fileName = fileName;
            this.hasColumnLine = hasColumnNameLine;
            Load();
        }
        
        public string GetFullPath()
        {
            return Path.GetFullPath(fileName);
        }

        private bool Load()
        {
            try
            {
                stream = new StreamReader(GetFullPath());
                return true;
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception.Message);
                return false;
            }
        }

        public List<string> GetLines()
        {
            List<string> lines = new List<string>();
            while (!stream.EndOfStream)
            {
                string line = stream.ReadLine();
                if (hasColumnLine)
                    continue;
                lines.Add(line);
            }

            stream.Close();
            return lines;
        }
    }
}
