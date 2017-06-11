target triple="x86_64"
%struct.intList = type {i64, %struct.intList*}

@intList = common global i64 0, align 8

define i64 @length(%struct.intList* %list)
{
LU0:
	%_retval_ = alloca i64
	%_P_list = alloca %struct.intList*
	store %struct.intList* %list, %struct.intList** %_P_list
	%u0 = load %struct.intList** %_P_list
	%u1 = icmp eq %struct.intList* %u0, null
	%u3 = zext i1 %u1 to i64
	%u4 = trunc i64 %u3 to i1
	br i1 %u4, label %LU2, label %LU3
LU1:
	%u10 = load i64* %_retval_
	ret i64 %u10
LU2:
	store i64 0, i64* %_retval_
	br label %LU1
LU3:
	br label %LU4
LU4:
	%u5 = load %struct.intList** %_P_list
	%u6 = getelementptr %struct.intList* %u5, i1 0, i32 1
	%u7 = load %struct.intList** %u6
	%u8 = call i64 @length(%struct.intList* %u7)
	%u9 = add i64 1, %u8
	store i64 %u9, i64* %_retval_
	br label %LU1
}

define %struct.intList* @addToFront(%struct.intList* %list, i64 %element)
{
LU5:
	%_retval_ = alloca %struct.intList*
	%_P_list = alloca %struct.intList*
	%_P_element = alloca i64
	%front = alloca %struct.intList*
	store %struct.intList* %list, %struct.intList** %_P_list
	store i64 %element, i64* %_P_element
	%u11 = load %struct.intList** %_P_list
	%u12 = icmp eq %struct.intList* %u11, null
	%u14 = zext i1 %u12 to i64
	%u15 = trunc i64 %u14 to i1
	br i1 %u15, label %LU7, label %LU8
LU6:
	%u33 = load %struct.intList** %_retval_
	ret %struct.intList* %u33
LU7:
	%u16 = call i8* @malloc(i64 16)
	%u17 = bitcast i8* %u16 to %struct.intList*
	store %struct.intList* %u17, %struct.intList** %_P_list
	%u18 = load i64* %_P_element
	%u19 = load %struct.intList** %_P_list
	%u20 = getelementptr %struct.intList* %u19, i1 0, i32 0
	store i64 %u18, i64* %u20
	%u21 = load %struct.intList** %_P_list
	%u22 = getelementptr %struct.intList* %u21, i1 0, i32 1
	store %struct.intList* null, %struct.intList** %u22
	%u23 = load %struct.intList** %_P_list
	store %struct.intList* %u23, %struct.intList** %_retval_
	br label %LU6
LU8:
	br label %LU9
LU9:
	%u24 = call i8* @malloc(i64 16)
	%u25 = bitcast i8* %u24 to %struct.intList*
	store %struct.intList* %u25, %struct.intList** %front
	%u26 = load i64* %_P_element
	%u27 = load %struct.intList** %front
	%u28 = getelementptr %struct.intList* %u27, i1 0, i32 0
	store i64 %u26, i64* %u28
	%u29 = load %struct.intList** %_P_list
	%u30 = load %struct.intList** %front
	%u31 = getelementptr %struct.intList* %u30, i1 0, i32 1
	store %struct.intList* %u29, %struct.intList** %u31
	%u32 = load %struct.intList** %front
	store %struct.intList* %u32, %struct.intList** %_retval_
	br label %LU6
}

define %struct.intList* @deleteFirst(%struct.intList* %list)
{
LU10:
	%_retval_ = alloca %struct.intList*
	%_P_list = alloca %struct.intList*
	%first = alloca %struct.intList*
	store %struct.intList* %list, %struct.intList** %_P_list
	%u34 = load %struct.intList** %_P_list
	%u35 = icmp eq %struct.intList* %u34, null
	%u37 = zext i1 %u35 to i64
	%u38 = trunc i64 %u37 to i1
	br i1 %u38, label %LU12, label %LU13
LU11:
	%u47 = load %struct.intList** %_retval_
	ret %struct.intList* %u47
LU12:
	store %struct.intList* null, %struct.intList** %_retval_
	br label %LU11
LU13:
	br label %LU14
LU14:
	%u39 = load %struct.intList** %_P_list
	store %struct.intList* %u39, %struct.intList** %first
	%u40 = load %struct.intList** %_P_list
	%u41 = getelementptr %struct.intList* %u40, i1 0, i32 1
	%u42 = load %struct.intList** %u41
	store %struct.intList* %u42, %struct.intList** %_P_list
	%u43 = load %struct.intList** %first
	%u45 = bitcast %struct.intList* %u43 to i8*
	call void @free(i8* %u45)
	%u46 = load %struct.intList** %_P_list
	store %struct.intList* %u46, %struct.intList** %_retval_
	br label %LU11
}

define i64 @main()
{
LU15:
	%_retval_ = alloca i64
	%list = alloca %struct.intList*
	%sum = alloca i64
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64* @intList)
	store i64 0, i64* %sum
	store %struct.intList* null, %struct.intList** %list
	%u56 = load i64* @intList
	%u57 = icmp sgt i64 %u56, 0
	%u59 = zext i1 %u57 to i64
	%u60 = trunc i64 %u59 to i1
	br i1 %u60, label %LU17, label %LU18
LU16:
	%u90 = load i64* %_retval_
	ret i64 %u90
LU17:
	%u48 = load %struct.intList** %list
	%u49 = load i64* @intList
	%u50 = call %struct.intList* @addToFront(%struct.intList* %u48, i64 %u49)
	store %struct.intList* %u50, %struct.intList** %list
	%u51 = load %struct.intList** %list
	%u52 = getelementptr %struct.intList* %u51, i1 0, i32 0
	%u53 = load i64* %u52
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.print, i32 0, i32 0), i64 %u53)
	%u54 = load i64* @intList
	%u55 = sub i64 %u54, 1
	store i64 %u55, i64* @intList
	%u61 = load i64* @intList
	%u62 = icmp sgt i64 %u61, 0
	%u64 = zext i1 %u62 to i64
	%u65 = trunc i64 %u64 to i1
	br i1 %u65, label %LU17, label %LU18
LU18:
	%u66 = load %struct.intList** %list
	%u67 = call i64 @length(%struct.intList* %u66)
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.print, i32 0, i32 0), i64 %u67)
	%u77 = load %struct.intList** %list
	%u78 = call i64 @length(%struct.intList* %u77)
	%u79 = icmp sgt i64 %u78, 0
	%u81 = zext i1 %u79 to i64
	%u82 = trunc i64 %u81 to i1
	br i1 %u82, label %LU19, label %LU20
LU19:
	%u68 = load i64* %sum
	%u69 = load %struct.intList** %list
	%u70 = getelementptr %struct.intList* %u69, i1 0, i32 0
	%u71 = load i64* %u70
	%u72 = add i64 %u68, %u71
	store i64 %u72, i64* %sum
	%u73 = load %struct.intList** %list
	%u74 = call i64 @length(%struct.intList* %u73)
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.print, i32 0, i32 0), i64 %u74)
	%u75 = load %struct.intList** %list
	%u76 = call %struct.intList* @deleteFirst(%struct.intList* %u75)
	store %struct.intList* %u76, %struct.intList** %list
	%u83 = load %struct.intList** %list
	%u84 = call i64 @length(%struct.intList* %u83)
	%u85 = icmp sgt i64 %u84, 0
	%u87 = zext i1 %u85 to i64
	%u88 = trunc i64 %u87 to i1
	br i1 %u88, label %LU19, label %LU20
LU20:
	%u89 = load i64* %sum
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u89)
	store i64 0, i64* %_retval_
	br label %LU16
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00", align 1
@.read_scratch = common global i64 0, align 8
