// This is a part of the Image I/O Library (ImageIOL)
// Copyright (c) 2003 Centre for Multimedia Signal Processing,  
// The Hong Kong Polytechnic University
// All rights reserved.
//
//------------------------------------------------------------------
// Title			: Image I/O Library
//
// Library Name     : ImageIOL
// File Name		: ImageIOL.h
// Module Leader	: Dr K.M. Lam
// Programmer       : Wong Kwok Wai
// Class Version    : 1.00
// Date             : 30 Dec 2003
//------------------------------------------------------------------
#include <stdio.h>

class __declspec(dllexport)CReadSaveImgFile  
{
public:
	
	bool SaveBMP(unsigned char* InputRawImage, char* FileName, int width, int height, int BitsPerPixel);
	bool ReadBMP(char* InputFileName);
	bool SaveRaw(unsigned char*InputRawImage, char *OutputFileName, int width, int height, int BitsPerPixel);
	CReadSaveImgFile();
	virtual ~CReadSaveImgFile();
	bool ReadRaw(char *InputFileName, unsigned char *OutputImage, int width, int height, int BitsPerPixels);

	// Return width of BMP image //
	int GetBMPWidth(){ return BMPWidth; }
	// Return height of BMP image //
	int GetBMPHeight(){ return BMPHeight; }
	// Return bits/pixel of BMP image //
	int GetBMPBitCount(){ return BMPBitCount; }

	// Return address of the buffer containing the RAW data of the BMP image //
	unsigned char *GetRGBRawImage(){ return RawImage; }

private:
	void WriteRAWToBMP(FILE *file, unsigned char *InputRawImage,int width, int height, int BitsPerPixel);
	void GetPalette(FILE *file,unsigned char *Palette, int PaletteSize);
	int GetBytesPerLine(int width , int BitsPerPixel);
	int GetPaletteSize(int BitsPerPixel);
	void WriteBitmapHeader(FILE *file, int width, int height, int BitsPerPixel);
	void GetRawFromDibBits(unsigned char* DibBits, int BiWidth, int BiHeight, int BiBitCount, unsigned char *Palettee);
	bool ReadBitmapHeader(FILE *file,int &BiWidth, int &BiHeight, int &BiBitCount, int &OffBits);
	int BMPWidth;
	int BMPHeight;
	int BMPBitCount;
	unsigned char *RawImage;
};

class __declspec(dllexport)CCreateNDimMemory  
{
public:
	CCreateNDimMemory();
	virtual ~CCreateNDimMemory();

	char  **Create2Dmemory(int rows, int cols, int size);
	void Del2Dmemory(char**array, int rows, int cols);

};
