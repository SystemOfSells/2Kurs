// laba4.cpp : Определяет точку входа для приложения.
//

#include "framework.h"
#include "laba4.h"

#define MAX_LOADSTRING 100

// Глобальные переменные:
HINSTANCE hInst;                                // текущий экземпляр
WCHAR szTitle[MAX_LOADSTRING];                  // Текст строки заголовка
WCHAR szWindowClass[MAX_LOADSTRING];            // имя класса главного окна
HWND hListBoxNames, hListBox2Names, hListBoxGroups
    ,hText1, hProgress1, hProgress2, hStatus1, hStatus2;
int pParts[2];

// Отправить объявления функций, включенных в этот модуль кода:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);

int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);

    // TODO: Разместите код здесь.

    // Инициализация глобальных строк
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_LABA4, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // Выполнить инициализацию приложения:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_LABA4));

    MSG msg;

    // Цикл основного сообщения:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  ФУНКЦИЯ: MyRegisterClass()
//
//  ЦЕЛЬ: Регистрирует класс окна.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_LABA4));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_LABA4);
    wcex.lpszClassName  = szWindowClass;
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

    return RegisterClassExW(&wcex);
}

//
//   ФУНКЦИЯ: InitInstance(HINSTANCE, int)
//
//   ЦЕЛЬ: Сохраняет маркер экземпляра и создает главное окно
//
//   КОММЕНТАРИИ:
//
//        В этой функции маркер экземпляра сохраняется в глобальной переменной, а также
//        создается и выводится главное окно программы.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // Сохранить маркер экземпляра в глобальной переменной

   HWND hWnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

//
//  ФУНКЦИЯ: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  ЦЕЛЬ: Обрабатывает сообщения в главном окне.
//
//  WM_COMMAND  - обработать меню приложения
//  WM_PAINT    - Отрисовка главного окна
//  WM_DESTROY  - отправить сообщение о выходе и вернуться
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message)
    {
    case WM_CREATE:
    {

        hStatus1 = CreateWindowEx(0, L"msctls_statusbar32", L"Group 1", WS_CHILD | WS_VISIBLE, 0, 0, 100, 50, hWnd, 0, NULL, NULL);

        //hStatus2 = CreateWindowEx(0, L"msctls_statusbar32", L"Group 2", WS_CHILD | WS_VISIBLE, 0, 0, 0, 0, hWnd, 0, NULL, NULL);


        hText1 = CreateWindow(L"STATIC", L"Group 1", WS_CHILD | WS_VISIBLE, 500, 80, 55, 20, hWnd, (HMENU)(-1), NULL, NULL);
        hProgress1 = CreateWindowEx(0, L"msctls_progress32", (LPTSTR)NULL,
            WS_CHILD | WS_VISIBLE, 450, 100, 150, 30,
            hWnd, (HMENU)ID_PROG1, hInst, NULL);

        hText1 = CreateWindow(L"STATIC", L"Group 2", WS_CHILD | WS_VISIBLE, 700, 80, 55, 20, hWnd, (HMENU)(-1), NULL, NULL);
        hProgress2 = CreateWindowEx(0, L"msctls_progress32", (LPTSTR)NULL,
            WS_CHILD | WS_VISIBLE, 650, 100, 150, 30,
            hWnd, (HMENU)ID_PROG1, hInst, NULL);

        hText1 = CreateWindow(L"STATIC", L"Name", WS_CHILD | WS_VISIBLE, 130, 80, 40, 20, hWnd, (HMENU)(-1), NULL, NULL);
        hListBoxNames = CreateWindow(L"combobox", NULL,
            WS_CHILD | WS_VISIBLE | BS_PUSHBOX,
            50, 100, 200, 200,
            hWnd, (HMENU)ID_LIST1, hInst, NULL);

        hText1 = CreateWindow(L"STATIC", L" Second Name", WS_CHILD | WS_VISIBLE, 100, 180, 100, 20, hWnd, (HMENU)(-1), NULL, NULL);
        hListBox2Names = CreateWindow(L"combobox", NULL,
            WS_CHILD | WS_VISIBLE | BS_PUSHBOX,
            50, 200, 200, 200,
            hWnd, (HMENU)ID_LIST2, hInst, NULL);

        hText1 = CreateWindow(L"STATIC", L"Group", WS_CHILD | WS_VISIBLE, 130, 280, 40, 20, hWnd, (HMENU)(-1), NULL, NULL);
        hListBoxGroups = CreateWindow(L"combobox", NULL,
            WS_CHILD | WS_VISIBLE | BS_PUSHBOX,
            50, 300, 200, 200,
            hWnd, (HMENU)ID_LIST3, hInst, NULL);

        SendMessage(hListBoxNames, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Киря");
        SendMessage(hListBoxNames, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Филя");
        SendMessage(hListBoxNames, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Пупа");
        SendMessage(hListBoxNames, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Лупа");
        SendMessage(hListBoxNames, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Степанос");

        SendMessage(hListBox2Names, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Иствуд");
        SendMessage(hListBox2Names, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Джилленхол");
        SendMessage(hListBox2Names, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Котиков");
        SendMessage(hListBox2Names, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Медведев");
        SendMessage(hListBox2Names, CB_ADDSTRING, 0,
            (LPARAM)(LPSTR)L"Джобс");


        SendMessage(hListBoxGroups, CB_ADDSTRING, 1,
            (LPARAM)(LPSTR)L"Group 1");
        SendMessage(hListBoxGroups, CB_ADDSTRING, 2,
            (LPARAM)(LPSTR)L"Group 2");
        break;
    }
    case WM_COMMAND:
    {
        int wmId = LOWORD(wParam);
        // Разобрать выбор в меню:


        switch (wmId)
        {
        case IDM_ABOUT:
            DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
            break;
        case IDM_EXIT:
            DestroyWindow(hWnd);
            break;
        //case ID_LIST3:
        //    char buf[10];
        //    GetDlgItemText(hListBoxGroups, ID_LIST3, (LPWSTR)buf, 9);
        //    MessageBox(NULL,(LPWSTR)buf, L"ВНИМАНИЕ!!!", MB_ICONASTERISK | MB_OK);
        case CBN_SELCHANGE:
        {
            TCHAR strText[255] = { 0 };
            int idx_row = SendMessage(hListBoxGroups, CB_GETCURSEL, 0, 0);
            SendMessage(hListBoxGroups, CB_GETLBTEXT, idx_row, (LPARAM)strText);
            MessageBox(NULL, strText, L"ВНИМАНИЕ!!!", MB_ICONASTERISK | MB_OK);
            break;
        }
        default:
            return DefWindowProc(hWnd, message, wParam, lParam);
        }
    }
    break;
    case WM_SIZE:
        int pParts[4];
        pParts[0] = 100; //часть 1 
        pParts[1] = 100 + 100; // часть 2
       
        SendMessage(hStatus1, WM_SIZE, 0, 0);
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HDC hdc = BeginPaint(hWnd, &ps);
            // TODO: Добавьте сюда любой код прорисовки, использующий HDC...
            EndPaint(hWnd, &ps);
        }
        break;
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}

// Обработчик сообщений для окна "О программе".
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
