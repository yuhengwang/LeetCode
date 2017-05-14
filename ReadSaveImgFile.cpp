// This is a part of the Image Input/Output Library (ImageIOL)
// Copyright (c) 2003 Centre for Multimedia Signal Processing,  
// The Hong Kong Polytechnic University
// All rights reserved.
//
//------------------------------------------------------------------
// Title			: Open/save image files
//
// Class Name       : CReadSaveImgFile
// File Name		: ReadSaveImgFile.cpp
// Module Leader	: Dr K.M Lam
// Programmer       : Wong Kwok Wai
// Class Version    : 1.00
// Date             : 03 March 2003
// DESC.			: Open/save image in RAW/BMP format 
//------------------------------------------------------------------
//#include "stdafx.h"
#include <Afxwin.h>
//#include "IPPRL.h"
#include "ReadSaveImgFile.h"
#include <stdio.h>

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CReadSaveImgFile::CReadSaveImgFile()
{
	RawImage=NULL;
	BMPWidth=0;
	BMPHeight=0;
	BMPBitCount=0;
}

CReadSaveImgFile::~CReadSaveImgFile()
{
	if (RawImage!=NULL)
		delete []RawImage;
}

//////////////////////////////////////////////////////////////////////
//  Read RAW image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::ReadRaw(char *InputFileName, BYTE *OutputImage, int width, int height, int BitsPerPixels)
{
	// calculate the file size  //
	int FileSize=int(height*width*BitsPerPixels/8.0);

	FILE *file;
	int Count;

	//errno_t err;

	// open file //
	//if( (err  = fopen_s( &file,InputFileName, "rb" ))== 0 )
	if( (file  = fopen( InputFileName, "rb" )) != NULL )
	{
		// read data from file //
		Count=fread(OutputImage,sizeof(BYTE),FileSize,file);
		fclose(file);

		if (Count!=FileSize)
		{			
			return false;
		}
		else
		{
			return true;
		}
		
	}
	else
	{
		return false;
	}
}

//////////////////////////////////////////////////////////////////////
//  Save RAW image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::SaveRaw(BYTE *InputRawImage, char *OutputFileName, int width, int height, int BitsPerPixel)
{
	// calculate the file size  //
	int FileSize=int(height*width*BitsPerPixel/8.0);

	FILE *file;

	int Count;

	// open file //
	if( (file  = fopen( OutputFileName, "wb" )) != NULL )
	{
		// write data into file //
		Count=fwrite(InputRawImage,sizeof(BYTE),FileSize,file);
		fclose(file);

		if (Count!=FileSize)
		{			
			return false;
		}
		else
		{
			return true;
		}
		
	}
	else
	{
		return false;
	}

}

//////////////////////////////////////////////////////////////////////
//  Save RAW image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::SaveRaw(BYTE *InputRawImage, CString OutputFileName, int width, int height, int BitsPerPixel)
{
	// calculate the file size  //
	int FileSize=int(height*width*BitsPerPixel/8.0);

	FILE *file;

	int Count;
	errno_t err;

	int i;
	int len = OutputFileName.GetLength();
	char * chr = new char[len+1];
	for(i=0; i < len; ++i)
	{ 
		chr[i] = (char)OutputFileName[i];
	}
	chr[i] = 0;

	// open file //
	if( (err  = fopen_s( &file,chr, "wb" )) == 0 )
	{
		// write data into file //
		Count=fwrite(InputRawImage,sizeof(BYTE),FileSize,file);
		fclose(file);

		if (Count!=FileSize)
		{			
			return false;
		}
		else
		{
			return true;
		}
		
	}
	else
	{
		return false;
	}

}

//////////////////////////////////////////////////////////////////////
//  Read BMP image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::ReadBMP(char *InputFileName)
{

	FILE *file;

	if	((file=fopen(InputFileName,"rb"))!=NULL)
	{
		int BiWidth, BiHeight, BiBitCount,bfOffBits;

		// reading the header info. 
		if (ReadBitmapHeader(file, BiWidth, BiHeight, BiBitCount,bfOffBits)==true)
		{		
			BMPWidth=BiWidth;
			BMPHeight=BiHeight;
			BMPBitCount=BiBitCount;

			// get the size of the palette 
			int PaletteSize=GetPaletteSize(BiBitCount);
			
			BYTE *Palette=new BYTE[PaletteSize*4];

			if (PaletteSize)
			{
				if ((bfOffBits-54)!=0)
				{
					// getting the palette data
					GetPalette(file,Palette,PaletteSize);
				}
			}
			
			// get the no. of bytes per line
			int BytesPerLine=GetBytesPerLine(BiWidth, BiBitCount);

			BYTE *DibBits=new BYTE[BytesPerLine*BiHeight];

			// reading the BMP contents
			fread(DibBits,sizeof(BYTE),BytesPerLine*BiHeight,file);

			fclose(file);

			if (RawImage!=NULL)
				delete []RawImage;

			RawImage=new BYTE[(int)(BiWidth)*(int)(BiHeight)*3];

			// copy the BMP contents to output buffer
			GetRawFromDibBits(DibBits,BiWidth, BiHeight, BiBitCount, Palette);

			delete []DibBits;
			delete []Palette;

			return true;
		}
		else
		{
			fclose(file);
			return false;
		}		   
	}
	else
	{
		return false;
	}

}
//////////////////////////////////////////////////////////////////////
//  Read BMP image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::ReadBMP(const char * InputFileName)
{

	FILE *file;

	if	((file=fopen(InputFileName,"rb"))!=NULL)
	{
		int BiWidth, BiHeight, BiBitCount,bfOffBits;

		// reading the header info. 
		if (ReadBitmapHeader(file, BiWidth, BiHeight, BiBitCount,bfOffBits)==true)
		{		
			BMPWidth=BiWidth;
			BMPHeight=BiHeight;
			BMPBitCount=BiBitCount;

			// get the size of the palette 
			int PaletteSize=GetPaletteSize(BiBitCount);
			
			BYTE *Palette=new BYTE[PaletteSize*4];

			if (PaletteSize)
			{
				if ((bfOffBits-54)!=0)
				{
					// getting the palette data
					GetPalette(file,Palette,PaletteSize);
				}
			}
			
			// get the no. of bytes per line
			int BytesPerLine=GetBytesPerLine(BiWidth, BiBitCount);

			BYTE *DibBits=new BYTE[BytesPerLine*BiHeight];

			// reading the BMP contents
			fread(DibBits,sizeof(BYTE),BytesPerLine*BiHeight,file);

			fclose(file);

			if (RawImage!=NULL)
				delete []RawImage;
			RawImage=new BYTE[(int)(BiWidth)*(int)(BiHeight)*3];

			// copy the BMP contents to output buffer
			GetRawFromDibBits(DibBits,BiWidth, BiHeight, BiBitCount, Palette);

			delete []DibBits;
			delete []Palette;

			return true;
		}
		else
		{
			fclose(file);
			return false;
		}		   
	}
	else
	{
		return false;
	}

}

//////////////////////////////////////////////////////////////////////
//  read BITMAP header Info 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::ReadBitmapHeader(FILE *file,int &width, int &height, int &BitCount, int &OffBits)
{
	unsigned short bfType; // Signiture of bitmap file 
    unsigned bfSize; // size of the BITMAP file
	
    unsigned short bfReserved1; // reserved 1
    unsigned short bfReserved2; // reserved 2
    unsigned bfOffBits; // header size = BITMAP header + BITMAPInfo + palette size
	unsigned BiSize; // BITMAPINFOHEADER size = 40
	unsigned BiWidth; // width of the image
	unsigned BiHeight; // height of the image
    unsigned short   BiPlanes; 
	unsigned short   BiBitCount; // bits per pixel
    unsigned  BiCompression; // compression method
    unsigned  BiSizeImage;  // DIB data size
    unsigned  BiXPelsPerMeter; 
    unsigned  BiYPelsPerMeter; 
    unsigned  BiClrUsed; 
    unsigned  BiClrImportant; 


	// reading BITMAP header info.
	fread(&bfType,sizeof(BYTE), 2,file );
	if (bfType!= 0x4D42) // Signiture of bitmap file "BM" 
	{
		return false;
	}
	fread(&bfSize,sizeof(unsigned int), 1,file );
	fread(&bfReserved1,sizeof(BYTE), 2,file );
	if (bfReserved1!=0)
	{
		return false;
	}
	fread(&bfReserved2,sizeof(BYTE), 2,file );
	if (bfReserved2!=0)
	{
		return false;
	}
	fread(&bfOffBits,sizeof(unsigned int), 1,file );
	OffBits=bfOffBits;

	fread(&BiSize,sizeof(unsigned int), 1,file );
	fread(&BiWidth,sizeof(unsigned int), 1,file );
	width=BiWidth;
	fread(&BiHeight,sizeof(unsigned int), 1,file );
	height=BiHeight;
	fread(&BiPlanes,sizeof(BYTE), 2,file );
	fread(&BiBitCount,sizeof(BYTE), 2,file );
	BitCount=BiBitCount;
	fread(&BiCompression,sizeof(unsigned int), 1,file );
	fread(&BiSizeImage,sizeof(unsigned int), 1,file );
	fread(&BiXPelsPerMeter,sizeof(unsigned int), 1,file );
	fread(&BiYPelsPerMeter,sizeof(unsigned int), 1,file );
	fread(&BiClrUsed,sizeof(unsigned int), 1,file );
	fread(&BiClrImportant,sizeof(unsigned int), 1,file );	
		
	return true;

}

//////////////////////////////////////////////////////////////////////
//  Get RAW data from BMP image file
//////////////////////////////////////////////////////////////////////
void CReadSaveImgFile::GetRawFromDibBits(BYTE *DibBits, int BiWidth, int BiHeight, int BiBitCount, BYTE *Palette)
{
	int index,index2;

	// get no. of bytes per line
	int BytesPerLine= GetBytesPerLine(BiWidth, BiBitCount);
	
	for (int i=0;i<int(BiHeight);i++)
		{			
			index=i*BiWidth*3;
			index2=BytesPerLine*(BiHeight-i)-BytesPerLine;

			for (int j=0; j<int(BiWidth);j++)
			{
				if (BiBitCount==24)
				{
					// getting RAW data from BMP image
					*(RawImage+3*j+index)=*(DibBits+index2+3*j+2);
					*(RawImage+3*j+index+1)=*(DibBits+index2+3*j+1);
					*(RawImage+3*j+index+2)=*(DibBits+index2+3*j);
				}
				else 
				{
					if (BiBitCount==8)
					{
						// getting RAW data from BMP image
						*(RawImage+3*j+index)=*(Palette+4*(*(DibBits+index2+j))+2);
						*(RawImage+3*j+index+1)=*(Palette+4*(*(DibBits+index2+j))+1);
						*(RawImage+3*j+index+2)=*(Palette+4*(*(DibBits+index2+j)));
					}
				}
			}
		}
}

//////////////////////////////////////////////////////////////////////
//  Save BMP image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::SaveBMP(BYTE *InputRawImage, char *FileName, int width, int height, int BitsPerPixel)
{
	// check the format is supported or not
	if (BitsPerPixel!=24 && BitsPerPixel!=8)
	{
		return false;
	}
	else
	{
		FILE *file;
		if ((file=fopen(FileName,"wb"))!=NULL)
		{
			// writting the header info.
			WriteBitmapHeader(file, width, height, BitsPerPixel);

			// writting image contents to BMP file
			WriteRAWToBMP(file, InputRawImage,width,  height, BitsPerPixel);			

			fclose(file);
			return true;

		}
		else
		{
			return false;
		}

		
	}
	
}

//////////////////////////////////////////////////////////////////////
//  Save BMP image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::SaveBMP(BYTE *InputRawImage, const char * FileName, int width, int height, int BitsPerPixel)
{
	// check the format is supported or not
	if (BitsPerPixel!=24 && BitsPerPixel!=8)
	{
		return false;
	}
	else
	{
		FILE *file;
		if ((file=fopen(FileName,"wb"))!=NULL)
		{
			// writting the header info.
			WriteBitmapHeader(file, width, height, BitsPerPixel);

			// writting image contents to BMP file
			WriteRAWToBMP(file, InputRawImage,width,  height, BitsPerPixel);			

			fclose(file);
			return true;

		}
		else
		{
			return false;
		}

		
	}
	
}

//////////////////////////////////////////////////////////////////////
//  Save BMP image file 
//////////////////////////////////////////////////////////////////////
bool CReadSaveImgFile::SaveBMP(BYTE *InputRawImage, CString FileName, int width, int height, int BitsPerPixel)
{
	
	// check the format is supported or not
	if (BitsPerPixel!=24 && BitsPerPixel!=8)
	{
		return false;
	}
	else
	{
		int i;
		FILE *file;
		errno_t err;

		int len = FileName.GetLength();
		char * chr = new char[len+1];
		for(i=0; i < len; ++i)
		{ 
			chr[i] = (char)FileName[i];
		}
		chr[i] = 0;

		if ((err=fopen_s(&file,chr,"wb"))==0)
		{
			// writting the header info.
			WriteBitmapHeader(file, width, height, BitsPerPixel);

			// writting image contents to BMP file
			WriteRAWToBMP(file, InputRawImage,width,  height, BitsPerPixel);			

			fclose(file);
			return true;

		}
		else
		{
			return false;
		}

		
	}
	
}

//////////////////////////////////////////////////////////////////////
//  Write BITMAP header 
//////////////////////////////////////////////////////////////////////
void CReadSaveImgFile::WriteBitmapHeader(FILE *file, int width, int height, int BitsPerPixel)
{
	//  get the no. of bytes used per line
	int BytesPerLine=GetBytesPerLine(width, BitsPerPixel);

	//  get palette size
	int PaletteSize=GetPaletteSize(BitsPerPixel);

	// initialize the BITMAP header info.
	unsigned short bfType= 0x4D42;
	unsigned bfSize=54+BytesPerLine*height+PaletteSize*4;
	unsigned short bfReserved1=0;
	unsigned short bfReserved2=0;
	unsigned bfOffBits=54+PaletteSize*4;

	unsigned  BiSize=40;
	unsigned BiWidth=width;
	unsigned BiHeight=height;
	unsigned short BiPlanes=1;
	unsigned short BiBitCount=BitsPerPixel;
	unsigned BiCompression=0;
	unsigned BiSizeImage=BytesPerLine*BiHeight;
	unsigned BiXPelsPerMeter=2851;
	unsigned BiYPelsPerMeter=2851;
	unsigned  BiClrUsed; 
	unsigned  BiClrImportant;

	if (BiBitCount==8)
	{
		BiClrUsed=256;
		BiClrImportant=256;	
	}
	else
	{
		if (BiBitCount==24)
		{
			BiClrUsed=0;
			BiClrImportant=0;	
		}
	}

	// writting the header info. to file
	fwrite(&bfType,sizeof(BYTE), 2,file );
	fwrite(&bfSize,sizeof(unsigned int), 1,file );
	fwrite(&bfReserved1,sizeof(BYTE), 2,file );
	fwrite(&bfReserved2,sizeof(BYTE), 2,file );
	fwrite(&bfOffBits,sizeof(unsigned int), 1,file );
	fwrite(&BiSize,sizeof(unsigned int), 1,file );
	fwrite(&BiWidth,sizeof(unsigned int), 1,file );
	fwrite(&BiHeight,sizeof(unsigned int), 1,file );
	fwrite(&BiPlanes,sizeof(BYTE), 2,file );
	fwrite(&BiBitCount,sizeof(BYTE), 2,file );
	fwrite(&BiCompression,sizeof(unsigned int), 1,file );
	fwrite(&BiSizeImage,sizeof(unsigned int), 1,file );
	fwrite(&BiXPelsPerMeter,sizeof(unsigned int), 1,file );
	fwrite(&BiYPelsPerMeter,sizeof(unsigned int), 1,file );
	fwrite(&BiClrUsed,sizeof(unsigned int), 1,file );
	fwrite(&BiClrImportant,sizeof(unsigned int), 1,file );	

	for (int i=0;i<PaletteSize;i++)
	{		
		fwrite(&i,sizeof(BYTE), 1,file );
		fwrite(&i,sizeof(BYTE), 1,file );
		fwrite(&i,sizeof(BYTE), 1,file );
		fwrite(&i,sizeof(BYTE), 1,file );
	}
	
}

//////////////////////////////////////////////////////////////////////
//  Get palette size of BMP file
//////////////////////////////////////////////////////////////////////
int CReadSaveImgFile::GetPaletteSize(int BitsPerPixel)
{
	int PaletteSize=0;

	switch (BitsPerPixel)
	{
		case 1:
			PaletteSize=2;
			break;
		case 4:
			PaletteSize=16;
			break;
		case 8:
			PaletteSize=256;
			break;
	}

	return PaletteSize;

}

//////////////////////////////////////////////////////////////////////
//  Calculate the no. of bytes used per line
//////////////////////////////////////////////////////////////////////
int CReadSaveImgFile::GetBytesPerLine(int width, int BitsPerPixel)
{
	// calaulate the no. of bytes used per line
	int BytesPerLine=(width*BitsPerPixel+7)/8;
	BytesPerLine=4*((BytesPerLine+3)/4);

	return BytesPerLine;
}


//////////////////////////////////////////////////////////////////////
//  Get palette info of BMP file
//////////////////////////////////////////////////////////////////////
void CReadSaveImgFile::GetPalette(FILE *file,BYTE *Palette, int PaletteSize)
{		
	// reading the palette info //
	fread(Palette,sizeof(BYTE), PaletteSize*4,file);
}

//////////////////////////////////////////////////////////////////////
//  Write RAW data to BMP file
//////////////////////////////////////////////////////////////////////
void CReadSaveImgFile::WriteRAWToBMP(FILE *file, BYTE *InputRawImage, int width, int height, int BitsPerPixel)
{
	// get no. of bytes per line
	int BytesPerLine=GetBytesPerLine(width, BitsPerPixel);

	for (int i=0;i<int(height);i++)
	{
		int index=(height-i-1)*width;
		if (BitsPerPixel==24) index=index*3;

		for (int j=0;j<int(width);j++)
		{
			if (BitsPerPixel==24)
			{
				// writting the RAW data to file
				fwrite((InputRawImage+index+3*j+2),sizeof(BYTE),1,file);
				fwrite((InputRawImage+index+3*j+1),sizeof(BYTE),1,file);
				fwrite((InputRawImage+index+3*j),sizeof(BYTE),1,file);					
			}
			else 
			{
				if (BitsPerPixel==8)
				{
					// writting the RAW data to file
					fwrite((InputRawImage+index+j),sizeof(BYTE),1,file);
				}
			}
		}

		// write zero to the remained bytes
		if (((int)(BytesPerLine)-width*(int)(BitsPerPixel/8.0))!=0)
		{
			fwrite("0000",sizeof(BYTE),(BytesPerLine-width*(int)(BitsPerPixel/8.0)),file);
		}
	}

}
