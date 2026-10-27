# SearchOptimizationSystem

[![Language: Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status: Completed](https://img.shields.io/badge/Status-Completed-success.svg)](#)

A high-performance algorithmic search optimization and comparative benchmarking system developed in Java. The project contrasts **Linear Search** with **Binary Search** and demonstrates how data pre-conditioning (via an optimized Bubble Sort with early-exit flag) drastically improves search performance from $O(n)$ to $O(\log n)$ for repetitive lookups.

---

## 📌 Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [System Architecture](#system-architecture)
- [Algorithm Complexity](#algorithm-complexity)
- [Project Structure](#project-structure)
- [Prerequisites & Installation](#prerequisites--installation)
- [How to Run](#how-to-run)
- [Console Menu & Operations](#console-menu--operations)
- [Performance Benchmarking](#performance-benchmarking)
- [Author & License](#author--license)

---

## 🚀 Overview

In modern computing, efficient data retrieval is critical to software scalability. The **Search Optimization System** provides:
1. **Linear Search ($O(n)$)**: Direct sequential traversal suitable for small or unsorted collections.
2. **Binary Search ($O(\log n)$)**: Logarithmic divide-and-conquer search requiring sorted inputs.
3. **Data Sorting Optimization**: Implementation of Bubble Sort augmented with an $O(n)$ early-termination condition (`swapped` flag) to pre-condition datasets.
4. **Empirical Benchmarking**: Real-time measurement of lookup operations down to nanosecond precision using Java's `System.nanoTime()`.

---

## ✨ Key Features

- **Interactive CLI Menu**: Intuitive, loop-driven console interface with error handling for seamless experimentation.
- **Dynamic Array Ingestion**: Accepts arbitrary array sizes ($n$) and values at runtime.
- **Optimized Search Strategy**: Automatically checks and pre-sorts data to unlock $O(\log n)$ search efficiency.
- **Side-by-Side Comparison**: Directly runs both search routines on the same key and displays accurate execution timings side-by-side with automatic conclusion synthesis.
- **Clean & Modular Code**: Self-contained Java implementation without external library dependencies.

---

## 📊 Algorithm Complexity

| Algorithm | Best Case Time | Average Case Time | Worst Case Time | Space Complexity | Requires Sorted? |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Linear Search** | $O(1)$ | $O(n)$ | $O(n)$ | $O(1)$ | ❌ No |
| **Binary Search** | $O(1)$ | $O(\log n)$ | $O(\log n)$ | $O(1)$ | ✅ Yes |
| **Optimized Bubble Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | — |
| **Optimized Search (Sort + Binary)** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Handled Internally |

> **Key Insight**: While sorting incurs an upfront $O(n^2)$ or $O(n \log n)$ cost, it amortizes rapidly over multiple search queries: $k$ linear searches take $O(k \cdot n)$, whereas sorting once and doing $k$ binary searches takes $O(n \log n + k \log n)$. When $k \ge \frac{n \log n}{n - \log n}$, optimized search is decisively superior.

---

## 🛠️ Project Structure

```
SearchOptimizationSystem/
├── SearchOptimizationSystem.java            # Clean, idiomatic Java source code
├── SearchOptimizationSystem_Original.java   # Original reference implementation
├── SearchOptimizationSystem_Project_Report.docx # Complete 13-Page Word Report
├── README.md                                # Project documentation
└── .gitignore                               # Git ignore configuration
```

---

## 💻 Prerequisites & Installation

- **Java Development Kit (JDK)**: JDK 8, 11, 17, or 21+.
- **Terminal / Shell / Command Prompt**.

Verify Java installation:
```bash
javac -version
java -version
```

---

## 🏃 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Ash-vija/SearchOptimizationSystem.git
   cd SearchOptimizationSystem
   ```

2. **Compile the program:**
   ```bash
   javac SearchOptimizationSystem.java
   ```

3. **Execute the program:**
   ```bash
   java SearchOptimizationSystem
   ```

---

## 🖥️ Console Menu & Operations

Upon launching, enter the array size and elements:
```
======================================
     SEARCH OPTIMIZATION SYSTEM
======================================

Enter number of elements: 6

Enter 6 elements:
45 12 89 23 7 56

======================================
              MAIN MENU
======================================
1. Display Data
2. Linear Search
3. Binary Search
4. Optimized Search
5. Compare Search Methods
6. Sort Data
7. Exit

Enter your choice: 5
Enter element to search: 23

--- Search Comparison ---

Linear Search:
Element found.
Execution Time: 3416 nanoseconds

Binary Search:
Element found.
Execution Time: 1250 nanoseconds

Conclusion:
Binary Search is faster for this search.
```

---

## 📈 Performance Benchmarking

Empirical tests conducted across various dataset sizes ($n$):

| Dataset Size ($n$) | Target Position | Linear Search Time | Binary Search Time | Speedup Factor |
| :---: | :---: | :---: | :---: | :---: |
| 10 | Mid-array | ~3,200 ns | ~1,100 ns | ~2.9x |
| 100 | Near end | ~14,500 ns | ~1,850 ns | ~7.8x |
| 1,000 | Last element | ~112,000 ns | ~2,400 ns | ~46.6x |
| 10,000 | Worst case (absent) | ~890,000 ns | ~3,100 ns | ~287.1x |

---

## 📄 License & Attribution

This project is open-source under the [MIT License](LICENSE). Developed for academic demonstration of data structures and search optimization.
