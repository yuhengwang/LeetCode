// This is a part of the Image Input/Output Library (ImageIOL)
// Copyright (c) 2003 Centre for Multimedia Signal Processing,  
// The Hong Kong Polytechnic University
// All rights reserved.
//
//------------------------------------------------------------------
// Title			: Open/save image files
//
// Class Name       : CReadSaveImgFile
// File Name		: ReadSaveImgFile.h
// Module Leader	: Dr K.M Lam
// Programmer       : Wong Kwok Wai
// Class Version    : 1.00
// Date             : 03 March 2003
// DESC.			: Open/save image in RAW/BMP format 
//------------------------------------------------------------------

#include <stdio.h>
#include <afxdlgs.h>

class CReadSaveImgFile  
{
public:
	bool ReadBMP(const char * InputFileName);
	bool SaveBMP(BYTE* InputRawImage, char* FileName, int width, int height, int BitsPerPixel);
	bool SaveBMP(BYTE* InputRawImage, const char * FileName, int width, int height, int BitsPerPixel);
	bool SaveBMP(BYTE* InputRawImage, CString FileName, int width, int height, int BitsPerPixel);


	bool ReadBMP(char* InputFileName);
	bool SaveRaw(BYTE*InputRawImage, char *OutputFileName, int width, int height, int BitsPerPixel);
	bool SaveRaw(BYTE*InputRawImage, CString OutputFileName, int width, int height, int BitsPerPixel);

	CReadSaveImgFile();
	virtual ~CReadSaveImgFile();
	bool ReadRaw(char *InputFileName, BYTE *OutputImage, int width, int height, int BitsPerPixels);

	// Return width of BMP image //
	int GetBMPWidth(){ return BMPWidth; }
	// Return height of BMP image //
	int GetBMPHeight(){ return BMPHeight; }
	// Return bits/pixel of BMP image //
	int GetBMPBitCount(){ return BMPBitCount; }

	// Return address of the buffer containing the RAW data of the BMP image //
	BYTE *GetRGBRawImage(){ return RawImage; }

private:
	void WriteRAWToBMP(FILE *file, BYTE *InputRawImage,int width, int height, int BitsPerPixel);
	void GetPalette(FILE *file,BYTE *Palette, int PaletteSize);
	int GetBytesPerLine(int width , int BitsPerPixel);
	int GetPaletteSize(int BitsPerPixel);
	void WriteBitmapHeader(FILE *file, int width, int height, int BitsPerPixel);
	void GetRawFromDibBits(BYTE* DibBits, int BiWidth, int BiHeight, int BiBitCount, BYTE *Palettee);
	bool ReadBitmapHeader(FILE *file,int &BiWidth, int &BiHeight, int &BiBitCount, int &OffBits);
	int BMPWidth;
	int BMPHeight;
	int BMPBitCount;
	BYTE *RawImage;
};

