target triple="x86_64"
%struct.simple = type {i64}
%struct.foo = type {i64, i64, %struct.simple*}

@globalfoo = common global %struct.foo* null, align 8

define void @tailrecursive(i64 %num)
{
LU0:
	%_P_num = alloca i64
	%unused = alloca %struct.foo*
	store i64 %num, i64* %_P_num
	%u0 = load i64* %_P_num
	%u1 = icmp sle i64 %u0, 0
	br i1 %u1, label %LU2, label %LU3
LU1:
	ret void
LU2:
	br label %LU1
LU3:
	br label %LU4
LU4:
	%u2 = call i8* @malloc(i64 24)
	%u3 = bitcast i8 %u2 to %struct.foo*
	store %struct.foo* %u3, %struct.foo** %unused
	%u4 = load i64* %_P_num
	%u5 = sub i64 %u4, 1
	call void @tailrecursive(i64 %u5)
	br label %LU1
}

define i64 @add(i64 %x, i64 %y)
{
LU5:
	%_retval_ = alloca i64
	%_P_x = alloca i64
	%_P_y = alloca i64
	store i64 %x, i64* %_P_x
	store i64 %y, i64* %_P_y
	%u7 = load i64* %_P_x
	%u8 = load i64* %_P_y
	%u9 = add i64 %u7, %u8
	store i64 %u9, i64* %_retval_
	br label %LU6
LU6:
	%u10 = load i64* %_retval_
	ret i64 %u10
}

define void @objinstantiation(i64 %num)
{
LU7:
	%_P_num = alloca i64
	%tmp = alloca %struct.foo*
	store i64 %num, i64* %_P_num
	%u15 = load i64* %_P_num
	%u16 = icmp sgt i64 %u15, 0
	br i1 %u16, label %LU9, label %LU10
LU8:
	ret void
LU9:
	%u11 = call i8* @malloc(i64 24)
	%u12 = bitcast i8 %u11 to %struct.foo*
	store %struct.foo* %u12, %struct.foo** %tmp
	%u13 = load i64* %_P_num
	%u14 = sub i64 %u13, 1
	store i64 %u14, i64* %num
	%u17 = load i64* %_P_num
	%u18 = icmp sgt i64 %u17, 0
	br i1 %u18, label %LU9, label %LU10
LU10:
	br label %LU8
}

define i64 @ackermann(i64 %m, i64 %n)
{
LU11:
	%_retval_ = alloca i64
	%_P_m = alloca i64
	%_P_n = alloca i64
	store i64 %m, i64* %_P_m
	store i64 %n, i64* %_P_n
	%u19 = load i64* %_P_m
	%u20 = icmp eq i64 %u19, 0
	br i1 %u20, label %LU13, label %LU14
LU12:
	%u35 = load i64* %_retval_
	ret i64 %u35
LU13:
	%u21 = load i64* %_P_n
	%u22 = add i64 %u21, 1
	store i64 %u22, i64* %_retval_
	br label %LU12
LU14:
	br label %LU15
LU15:
	%u23 = load i64* %_P_n
	%u24 = icmp eq i64 %u23, 0
	br i1 %u24, label %LU16, label %LU17
LU16:
	%u25 = load i64* %_P_m
	%u26 = sub i64 %u25, 1
	%u27 = call i64 @ackermann(i64 %u26, i64 1)
	store i64 %u27, i64* %_retval_
	br label %LU12
LU17:
	%u28 = load i64* %_P_m
	%u29 = sub i64 %u28, 1
	%u30 = load i64* %_P_m
	%u31 = load i64* %_P_n
	%u32 = sub i64 %u31, 1
	%u33 = call i64 @ackermann(i64 %u30, i64 %u32)
	%u34 = call i64 @ackermann(i64 %u29, i64 %u33)
	store i64 %u34, i64* %_retval_
	br label %LU12
}

define i64 @main()
{
LU18:
	%_retval_ = alloca i64
	%a = alloca i64
	%b = alloca i64
	%c = alloca i64
	%d = alloca i64
	%e = alloca i64
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %a)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %b)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %c)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %d)
	call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([4 x i8]* @.read, i32 0, i32 0), i64 %e)
	%u36 = load i64* %a
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u36)
	%u37 = load i64* %b
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u37)
	%u38 = load i64* %c
	call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.println, i32 0, i32 0), i64 %u38)
	store i64 0, i64* %_retval_
	br label %LU19
LU19:
	%u39 = load i64* %_retval_
	ret i64 %u39
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00", align 1
@.read_scratch = common global i64 0, align 8
